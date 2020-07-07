package com.home.splashdemo2.di.modules.mapper

import com.home.data.mapper.Mapper
import com.home.data.model.PhotoUrlsData
import com.home.data.model.ProfileImageData
import com.home.presentation.entity.ParcelPhotoEntity
import com.home.presentation.mapper.PhotoUrlsDataToParcelPhotoUrlsData
import com.home.presentation.mapper.ProfileImageDataToParcelProfileImageData
import com.home.presentation.model.ParcelPhotoUrlsData
import com.home.presentation.model.ParcelProfileImageData
import com.home.splashdemo2.di.scopes.ForActivity
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    @ForActivity
    fun provideProfileImageDataToParcelProfileImageData()
            : Mapper<ProfileImageData?, ParcelProfileImageData?> {
        return ProfileImageDataToParcelProfileImageData()
    }

    @Provides
    @ForActivity
    fun providePhotoUrlsDataToParcelPhotoUrlsData()
            : Mapper<PhotoUrlsData?, ParcelPhotoUrlsData?> {
        return PhotoUrlsDataToParcelPhotoUrlsData()
    }
}