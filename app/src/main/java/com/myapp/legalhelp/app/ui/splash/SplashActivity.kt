package com.myapp.legalhelp.app.ui.splash

import android.os.Bundle
import com.myapp.legalhelp.R
import com.myapp.legalhelp.app.base.BaseActivity
import com.myapp.legalhelp.app.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: BaseActivity<SplashViewModel>(R.layout.activity_splash, SplashViewModel::class){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        image_view.postDelayed({MainActivity.start(this)}, 3000)

    }
}