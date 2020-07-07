package com.home.splashdemo2.photolist.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.home.data.entity.CommentEntity
import com.home.data.provider.base.Provider
import com.home.presentation.home.contract.HomeContract
import com.home.presentation.home.viewmodel.HomeViewModel
import com.home.splashdemo.activity.SplashActivity
import com.home.splashdemo2.utils.applicationComponent
import com.home.splashdemo2.photopreview.adapter.PhotoPreviewAdapter
import com.home.splashdemo2.R
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : SplashActivity<HomeContract.Presenter>(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter

    @Inject
    lateinit var emptyPhotoEntityProvider: Provider<CommentEntity>

    private lateinit var homeViewModel: HomeViewModel

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        PhotoPreviewAdapter()
    }

    private val layoutManager by lazy(LazyThreadSafetyMode.NONE) {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        applicationComponent.homeActivityInjector().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
        initViewModel()
        presenter.subscribeView(this)
        presenter.subscribeViewModel(homeViewModel)
    }

    private fun initView() {
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                presenter.onPageScroll()
            }
        })
    }

    private fun initViewModel() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.commentsObservable.observe(this, Observer { comments ->
            adapter.updateItems(comments)
        })
    }

    override fun getTotalItems(): Int {
        return layoutManager.itemCount
    }

    override fun getLastVisibleItem(): Int {
        return layoutManager.findLastVisibleItemPosition()
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        homeViewModel.commentsObservable.removeObservers(this)
        super.onDestroy()
    }
}
