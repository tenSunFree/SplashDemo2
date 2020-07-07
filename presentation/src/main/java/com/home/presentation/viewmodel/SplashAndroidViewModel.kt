package com.home.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.functions.Consumer

abstract class SplashAndroidViewModel<InputType>(
    application: Application
) : AndroidViewModel(application), Consumer<InputType>