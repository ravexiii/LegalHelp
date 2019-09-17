package com.myapp.legalhelp.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.myapp.legalhelp.app.di.appModule
import com.myapp.legalhelp.app.di.vmModule
import com.myapp.legalhelp.app.utils.LocaleManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidFileProperties()
            modules(vmModule, appModule)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base))
        MultiDex.install(this)
    }

    override fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
}