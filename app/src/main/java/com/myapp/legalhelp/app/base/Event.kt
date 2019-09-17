package com.myapp.legalhelp.app.base

sealed class Event

sealed class SplashEvent : Event() {
    class GoToLogin : SplashEvent()
    class GoToMain : SplashEvent()
}