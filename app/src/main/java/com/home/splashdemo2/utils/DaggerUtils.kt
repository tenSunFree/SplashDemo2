package com.home.splashdemo2.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.home.remote.di.NetworkComponent
import com.home.splashdemo2.SplashApplication
import com.home.splashdemo2.di.ApplicationComponent

val AppCompatActivity.applicationComponent: ApplicationComponent
    get() {
        return (this.application as SplashApplication).applicationComponent
    }

val AppCompatActivity.networkComponent: NetworkComponent
    get() {
        return (this.application as SplashApplication).networkComponent
    }

val Fragment.applicationComponent: ApplicationComponent
    get() {
        return (this.activity?.application as SplashApplication).applicationComponent
    }

val Fragment.networkComponent: NetworkComponent
    get() {
        return (this.activity?.application as SplashApplication).networkComponent
    }