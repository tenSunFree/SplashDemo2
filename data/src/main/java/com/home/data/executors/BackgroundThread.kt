package com.home.data.executors

import com.home.data.executors.base.ApplicationThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class BackgroundThread : ApplicationThread {

    override fun getScheduler(): Scheduler {
        return Schedulers.io()
    }
}