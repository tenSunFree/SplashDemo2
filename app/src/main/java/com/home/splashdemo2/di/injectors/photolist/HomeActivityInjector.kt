package com.home.splashdemo2.di.injectors.photolist

import com.home.splashdemo2.di.modules.photolist.PhotoListModule
import com.home.splashdemo2.di.scopes.ForActivity
import com.home.splashdemo2.photolist.activity.HomeActivity
import dagger.Subcomponent

@Subcomponent(modules = [PhotoListModule::class])
@ForActivity
interface HomeActivityInjector {

    fun inject(activity: HomeActivity)
}