package com.home.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.home.data.entity.CommentEntity
import com.home.presentation.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel<MutableList<CommentEntity>>() {

    private val _commentsObservable
            by lazy(LazyThreadSafetyMode.NONE) { MutableLiveData<MutableList<CommentEntity>>() }
    val commentsObservable: LiveData<MutableList<CommentEntity>>
            by lazy(LazyThreadSafetyMode.NONE) { _commentsObservable }

    override fun accept(nextComments: MutableList<CommentEntity>) {
        val comments = _commentsObservable.value
        if (comments != null) {
            comments.addAll(nextComments)
            _commentsObservable.value = comments
        } else {
            _commentsObservable.value = nextComments
        }
    }
}












