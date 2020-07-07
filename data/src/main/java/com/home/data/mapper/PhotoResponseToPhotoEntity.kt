package com.home.data.mapper

import com.home.data.entity.CommentEntity
import com.home.data.response.CommentResponse

class PhotoResponseToPhotoEntity : Mapper<CommentResponse, CommentEntity> {

    override fun mapFromTo(from: CommentResponse): CommentEntity {
        return CommentEntity(
            from.postId,
            from.id,
            from.name,
            from.email,
            from.body
        )
    }

    override fun mapToFrom(to: CommentEntity): CommentResponse {
        return CommentResponse(
            to.postId,
            to.id,
            to.name,
            to.email,
            to.body
        )
    }
}