package com.home.remote.datasource

import com.home.data.datasource.DataSource
import com.home.data.request.GetCommentsRequest
import com.home.data.response.CommentResponse
import com.home.remote.api.PhotosAPI
import io.reactivex.Single
import javax.inject.Inject

class GetCommentsRemoteDataSource @Inject constructor(
    private val api: PhotosAPI
) : DataSource.SingleReadable<GetCommentsRequest, List<CommentResponse>> {

    override fun read(input: GetCommentsRequest): Single<List<CommentResponse>> {
        return api.getComments(input.postId)
    }
}