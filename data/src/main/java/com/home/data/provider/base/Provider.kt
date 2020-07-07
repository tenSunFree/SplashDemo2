package com.home.data.provider.base

interface Provider<Output> {

    interface WithInput<Input, Output> {
        fun provide(input: Input): Output
    }

    fun provide(): Output
}