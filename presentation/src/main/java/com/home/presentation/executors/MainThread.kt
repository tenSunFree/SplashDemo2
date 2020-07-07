package com.home.presentation.executors

import com.home.data.executors.base.ApplicationThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class MainThread : ApplicationThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}