package com.home.data.datasource

import io.reactivex.Completable
import io.reactivex.Single

interface DataSource {

    interface SingleCreatable<InputType, OutputType> {
        fun create(input: InputType? = null): Single<OutputType>
    }

    interface SingleReadable<InputType, OutputType> {
        fun read(input: InputType): Single<OutputType>
    }

    interface CompletableCreatable<InputType> {
        fun read(input: InputType? = null): Completable
    }
}