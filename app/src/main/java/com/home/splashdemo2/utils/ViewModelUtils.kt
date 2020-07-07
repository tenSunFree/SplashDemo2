package com.home.splashdemo2.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> FragmentActivity.viewModelProvider(
    crossinline factory: () -> T
): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this@viewModelProvider, viewModelFactory(factory))[T::class.java]
    }
}

inline fun <reified T : ViewModel> Fragment.viewModelProvider(
    crossinline factory: () -> T
): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this@viewModelProvider, viewModelFactory(factory))[T::class.java]
    }
}

inline fun <reified T : ViewModel> viewModelFactory(
    crossinline factory: () -> T
): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
}