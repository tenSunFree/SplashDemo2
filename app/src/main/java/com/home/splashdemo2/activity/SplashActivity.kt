package com.home.splashdemo.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.home.presentation.presenter.BasePresenter
import com.home.presentation.view.BaseView

abstract class SplashActivity<Presenter : BasePresenter<*>>
    : AppCompatActivity(), BaseView<Presenter> {

    override fun showToast(message: Int) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}