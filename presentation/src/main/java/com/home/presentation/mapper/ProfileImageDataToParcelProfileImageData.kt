package com.home.presentation.mapper

import com.home.data.mapper.Mapper
import com.home.data.model.ProfileImageData
import com.home.presentation.model.ParcelProfileImageData

class ProfileImageDataToParcelProfileImageData :
    Mapper<ProfileImageData?, ParcelProfileImageData?> {

    override fun mapFromTo(from: ProfileImageData?): ParcelProfileImageData? {
        return from?.let { nonNullFrom ->
            ParcelProfileImageData(nonNullFrom.small, nonNullFrom.medium, nonNullFrom.large)
        }
    }

    override fun mapToFrom(to: ParcelProfileImageData?): ProfileImageData? {
        return to?.let { nonNullTo ->
            ProfileImageData(nonNullTo.small, nonNullTo.medium, nonNullTo.large)
        }
    }
}