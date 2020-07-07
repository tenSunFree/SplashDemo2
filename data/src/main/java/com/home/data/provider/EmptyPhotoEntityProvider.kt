package com.home.data.provider

import com.home.data.entity.CommentEntity
import com.home.data.provider.base.Provider

class EmptyPhotoEntityProvider : Provider<CommentEntity> {

    override fun provide(): CommentEntity {
        return CommentEntity(
            1,
            1,
            "",
            "",
            ""
        )
    }
}