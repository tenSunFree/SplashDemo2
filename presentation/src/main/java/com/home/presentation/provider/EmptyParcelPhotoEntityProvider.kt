package com.home.presentation.provider

import com.home.data.provider.base.Provider
import com.home.presentation.entity.ParcelPhotoEntity

class EmptyParcelPhotoEntityProvider : Provider<ParcelPhotoEntity> {

    override fun provide(): ParcelPhotoEntity {
        return ParcelPhotoEntity(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }
}