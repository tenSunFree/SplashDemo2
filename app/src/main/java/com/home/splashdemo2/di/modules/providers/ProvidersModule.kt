package com.home.splashdemo2.di.modules.providers

import com.home.data.entity.CommentEntity
import com.home.data.provider.EmptyPhotoEntityProvider
import com.home.data.provider.base.Provider
import com.home.presentation.entity.ParcelPhotoEntity
import com.home.presentation.provider.EmptyParcelPhotoEntityProvider
import com.home.remote.provider.SigProvider
import com.home.splashdemo2.di.scopes.ForActivity
import dagger.Module
import dagger.Provides

@Module
class ProvidersModule {

    @Provides
    @ForActivity
    fun provideEmptyPhotoEntityProvider(): Provider<CommentEntity> {
        return EmptyPhotoEntityProvider()
    }

    @Provides
    @ForActivity
    fun provideEmptyParcelPhotoEntityProvider(): Provider<ParcelPhotoEntity> {
        return EmptyParcelPhotoEntityProvider()
    }

    @Provides
    @ForActivity
    fun provideSigProvider(): Provider<Long> {
        return SigProvider()
    }
}