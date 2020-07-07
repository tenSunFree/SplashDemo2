package com.home.presentation.presenter

import com.home.presentation.view.BaseView

interface BasePresenter<in View : BaseView<*>> {

    fun subscribeView(view: View)

    fun unsubscribe()
}