package com.home.data.executors.base

import io.reactivex.Scheduler

interface ApplicationThread {
    fun getScheduler(): Scheduler
}