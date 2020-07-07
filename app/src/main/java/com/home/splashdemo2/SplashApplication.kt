package com.home.splashdemo2

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.home.data.Loggerg
import com.home.remote.di.DaggerNetworkComponent
import com.home.remote.di.NetworkComponent
import com.home.remote.di.NetworkModule
import com.home.splashdemo2.di.ApplicationComponent
import com.home.splashdemo2.di.DaggerApplicationComponent
import com.home.splashdemo2.di.SplashModule
import com.squareup.picasso.Picasso
import javax.inject.Inject

class SplashApplication : Application() {

    @Inject
    lateinit var picasso: Picasso

    lateinit var networkComponent: NetworkComponent

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        Loggerg.d("SplashApplication, onCreate")
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        networkComponent = DaggerNetworkComponent.builder()
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .build()

        applicationComponent = DaggerApplicationComponent.builder()
            .networkComponent(networkComponent)
            .splashModule(SplashModule(this))
            .build()

        applicationComponent.inject(this)

        Picasso.setSingletonInstance(picasso)
    }
}