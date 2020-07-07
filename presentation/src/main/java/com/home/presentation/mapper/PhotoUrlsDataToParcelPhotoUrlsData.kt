package com.home.presentation.mapper

import com.home.data.mapper.Mapper
import com.home.data.model.PhotoUrlsData
import com.home.presentation.model.ParcelPhotoUrlsData

class PhotoUrlsDataToParcelPhotoUrlsData : Mapper<PhotoUrlsData?, ParcelPhotoUrlsData?> {

    override fun mapFromTo(from: PhotoUrlsData?): ParcelPhotoUrlsData? {
        return from?.let { nonNullFrom ->
            ParcelPhotoUrlsData(
                nonNullFrom.raw,
                nonNullFrom.full,
                nonNullFrom.regular,
                nonNullFrom.small,
                nonNullFrom.thumb
            )
        }
    }

    override fun mapToFrom(to: ParcelPhotoUrlsData?): PhotoUrlsData? {
        return to?.let { nonNullTo ->
            PhotoUrlsData(
                nonNullTo.raw,
                nonNullTo.full,
                nonNullTo.regular,
                nonNullTo.small,
                nonNullTo.thumb
            )
        }
    }
}