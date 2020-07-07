package com.home.presentation.home.presenter

import com.home.data.executors.base.ApplicationThread
import com.home.data.repository.photolist.HomeRepository
import com.home.data.request.GetCommentsRequest
import com.home.presentation.BuildConfig
import com.home.presentation.executors.qualifiers.BackgroundThreadQ
import com.home.presentation.executors.qualifiers.MainThreadQ
import com.home.presentation.home.contract.HomeContract
import com.home.presentation.home.viewmodel.HomeViewModel
import com.home.presentation.utils.composite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import javax.inject.Inject
import kotlin.math.roundToInt

class HomePresenter @Inject constructor(
    private val repository: HomeRepository,
    private val compositeDisposable: CompositeDisposable,
    @MainThreadQ private val mainThread: ApplicationThread,
    @BackgroundThreadQ private val backgroundThread: ApplicationThread
) : HomeContract.Presenter {

    companion object {
        private const val NEXT_PAGE_RATIO = 0.1
    }

    lateinit var view: HomeContract.View
    lateinit var viewModel: HomeViewModel
    private var isLoading = false
    private var getCommentsRequest = GetCommentsRequest(1)

    override fun subscribeView(view: HomeContract.View) {
        this.view = view
    }

    override fun subscribeViewModel(viewModel: HomeViewModel) {
        this.viewModel = viewModel
        if (viewModel.commentsObservable.value == null) getComments()
    }

    private fun getComments() {
        isLoading = true
        repository.getComments(getCommentsRequest)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
            .doOnSuccess {
                isLoading = false
                getCommentsRequest = getCommentsRequest.copy(getCommentsRequest.postId + 1)
            }
            .subscribe(viewModel, Consumer { throwable ->
                if (BuildConfig.DEBUG) throwable.printStackTrace()
            })
            .composite(compositeDisposable)
    }

    override fun onPageScroll() {
        if (isLoading) return
        val isLoadNextPage =
            (view.getTotalItems() * NEXT_PAGE_RATIO).roundToInt() <= view.getLastVisibleItem()
        if (isLoadNextPage) getComments()
    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }
}