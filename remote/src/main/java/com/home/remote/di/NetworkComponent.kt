package com.home.remote.di

import com.home.remote.api.PhotosAPI
import com.home.remote.di.modules.ApiModule
import com.home.remote.di.scopes.ForNetwork
import dagger.Component
import okhttp3.OkHttpClient

@Component(modules = [NetworkModule::class, ApiModule::class])
@ForNetwork
interface NetworkComponent {

    fun okHttpClient(): OkHttpClient

    fun photosAPI(): PhotosAPI
}