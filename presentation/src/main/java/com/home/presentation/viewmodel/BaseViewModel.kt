package com.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.functions.Consumer

abstract class BaseViewModel<InputType> : ViewModel(), Consumer<InputType>