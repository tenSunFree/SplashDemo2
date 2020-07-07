package com.home.remote.provider

import com.home.data.provider.base.Provider

class SigProvider : Provider<Long> {

    override fun provide(): Long {
        return System.currentTimeMillis()
    }
}