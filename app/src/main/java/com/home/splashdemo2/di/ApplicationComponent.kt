package com.home.splashdemo2.di

import com.home.remote.di.NetworkComponent
import com.home.splashdemo2.di.injectors.photolist.HomeActivityInjector
import com.home.splashdemo2.di.modules.thread.ThreadModule
import com.home.splashdemo2.di.scopes.ForApplication
import com.home.splashdemo2.SplashApplication
import dagger.Component

@Component(
    modules = [SplashModule::class, ThreadModule::class],
    dependencies = [NetworkComponent::class]
)
@ForApplication
interface ApplicationComponent {

    fun inject(application: SplashApplication)

    fun homeActivityInjector(): HomeActivityInjector
}