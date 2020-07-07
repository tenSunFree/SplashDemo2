package com.home.presentation.home.contract

import com.home.presentation.home.viewmodel.HomeViewModel
import com.home.presentation.presenter.BasePresenter
import com.home.presentation.view.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun getTotalItems(): Int

        fun getLastVisibleItem(): Int
    }

    interface Presenter : BasePresenter<View> {

        fun subscribeViewModel(viewModel: HomeViewModel)

        fun onPageScroll()
    }
}