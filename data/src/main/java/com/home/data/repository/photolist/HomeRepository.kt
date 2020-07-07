package com.home.data.repository.photolist

import com.home.data.entity.CommentEntity
import com.home.data.request.GetCommentsRequest
import io.reactivex.Single

interface HomeRepository {

    fun getComments(request: GetCommentsRequest): Single<MutableList<CommentEntity>>
}