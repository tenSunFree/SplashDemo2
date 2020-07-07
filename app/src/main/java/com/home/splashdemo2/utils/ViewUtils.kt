package com.home.splashdemo2.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutId, this, attachToParent)
}

fun Context.displayMetrics(): DisplayMetrics {
    return this.resources.displayMetrics
}

fun View.displayMetrics(): DisplayMetrics {
    return this.context.displayMetrics()
}