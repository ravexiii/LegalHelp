package com.myapp.legalhelp.app.di

import com.myapp.legalhelp.app.localstorage.PreferenceHelper
import com.myapp.legalhelp.app.network.ServerErrorHandler
import com.myapp.legalhelp.app.ui.main.MainViewModel
import com.myapp.legalhelp.app.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
}

val appModule = module {
    single { PreferenceHelper(get()) }
    single { ServerErrorHandler(get()) }
    single { androidContext().resources }
}
