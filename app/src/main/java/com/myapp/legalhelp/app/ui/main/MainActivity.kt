package com.myapp.legalhelp.app.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.myapp.legalhelp.R
import com.myapp.legalhelp.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main, MainViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar(toolbar, getString(R.string.main_page), -1, null)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
