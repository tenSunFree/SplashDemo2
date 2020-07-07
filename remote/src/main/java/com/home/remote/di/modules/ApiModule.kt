package com.home.remote.di.modules

import com.home.remote.api.PhotosAPI
import com.home.remote.di.scopes.ForNetwork
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @ForNetwork
    fun providePhotosApi(retrofit: Retrofit): PhotosAPI {
        return retrofit.create(PhotosAPI::class.java)
    }
}