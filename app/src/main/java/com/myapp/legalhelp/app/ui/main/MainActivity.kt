package com.myapp.legalhelp.app.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.myapp.legalhelp.R
import com.myapp.legalhelp.app.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main, MainViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar(toolbar)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
