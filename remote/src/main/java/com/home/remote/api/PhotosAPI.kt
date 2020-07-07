package com.home.remote.api

import com.home.data.response.CommentResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosAPI {

    @GET("/comments")
    fun getComments(
        @Query("postId") postId: Int
    ): Single<List<CommentResponse>>
}