package com.myapp.legalhelp.app.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapp.legalhelp.app.network.ServerErrorHandler

open class BaseViewModel<T : Event> : ViewModel() {
    var event: MutableLiveData<Pair<Event, Any>> = MutableLiveData()
    var showProgress: MutableLiveData<Boolean> = MutableLiveData()
    lateinit var errorHandler: ServerErrorHandler

    fun setProgress(isShow: Boolean){
        showProgress.value = isShow
    }

}