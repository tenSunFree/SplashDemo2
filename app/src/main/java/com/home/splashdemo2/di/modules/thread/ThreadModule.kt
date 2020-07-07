package com.home.splashdemo2.di.modules.thread

import com.home.data.executors.BackgroundThread
import com.home.data.executors.base.ApplicationThread
import com.home.presentation.executors.MainThread
import com.home.presentation.executors.qualifiers.BackgroundThreadQ
import com.home.presentation.executors.qualifiers.MainThreadQ
import com.home.splashdemo2.di.scopes.ForApplication
import dagger.Module
import dagger.Provides

@Module
class ThreadModule {

    @Provides
    @ForApplication
    @MainThreadQ
    fun provideMainThread(): ApplicationThread {
        return MainThread()
    }

    @Provides
    @ForApplication
    @BackgroundThreadQ
    fun provideBackgroundThread(): ApplicationThread {
        return BackgroundThread()
    }
}