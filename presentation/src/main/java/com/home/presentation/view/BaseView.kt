package com.home.presentation.view

import androidx.annotation.StringRes

interface BaseView<in Presenter> {

    fun showToast(@StringRes message: Int)
}