package com.myapp.legalhelp.app.network

import android.content.Context
import com.myapp.legalhelp.R
import com.myapp.legalhelp.app.extansions.showToast

class ServerErrorHandler(val context: Context) {

    fun onUnknownError() {
        context.showToast(context.getString(R.string.error_server_unknown))
    }

    fun noInternetConnection() {
        context.showToast(context.getString(R.string.error_no_internet))
    }

    fun onTimeOutError() {
        context.showToast(context.getString(R.string.error_server_timeout))
    }

    fun onNetworkError() {
        context.showToast(context.getString(R.string.error_network_error))
    }

    fun handleNetworkError(msg: String?) {
        val message = if(msg.isNullOrEmpty())context.getString(R.string.error_network_error) else msg
        context.showToast(message)
    }

    fun serviceUnavailable() {
        context.showToast(context.getString(R.string.error_server_service_unavailable))
    }

}
