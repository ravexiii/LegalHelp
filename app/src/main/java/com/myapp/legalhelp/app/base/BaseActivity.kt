package com.myapp.legalhelp.app.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.myapp.legalhelp.app.network.ServerErrorHandler
import com.myapp.legalhelp.app.utils.LocaleManager
import org.koin.android.ext.android.inject
import kotlin.reflect.KClass

open class BaseActivity<T : ViewModel>(@LayoutRes val layout: Int, val vmClass: KClass<T>) : AppCompatActivity() {

    //lateinit var vm: T
    var progressBar: Dialog? = null
    val errorHandler: ServerErrorHandler by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        vm = getViewModel(vmClass)
        setContentView(layout)
//        (vm as? BaseViewModel<*>)?.let {
//            it.showProgress.observe(this, Observer {
//                it?.let { setProgressBarState(it) }
//            })
//            it.errorHandler = errorHandler
//        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base))
    }

    private fun setProgressBarState(isShow: Boolean) {
        if (isShow) {
            progressBar = AlertDialog.Builder(this)
                .setMessage("Загрузка").create()
            progressBar?.show()
        } else {
            progressBar?.dismiss()
        }
    }

    @SuppressLint("NewApi")
    fun setViewBackground(view: View, resId: Int) {
        when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN -> view.setBackgroundDrawable(resources.getDrawable(resId))
            Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1 -> view.background = resources.getDrawable(resId)
            else -> view.background = ContextCompat.getDrawable(this, resId)
        }
    }

    protected fun finishActivityListener() = View.OnClickListener { onBackPressed() }

    fun getResourceString(id: Int): String {
        return getString(id)
    }

    protected fun setupToolbar(
        toolbar: Toolbar, @Nullable title: String, @DrawableRes icon: Int,
        listener: View.OnClickListener?
    ) {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = title
        if (icon != -1) {
            toolbar.setNavigationIcon(icon)
            toolbar.setNavigationOnClickListener(listener)
        } else {
            toolbar.navigationIcon = null
        }
    }

    override fun onPause(){
        super.onPause()
        detectOnSleep()
    }

    private fun detectOnSleep() {
            /*** to detect android sleep mode  */
            val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
            val isScreenOn: Boolean
            isScreenOn = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) powerManager.isInteractive
            else powerManager.isScreenOn
            /*** if it is on sleep mode, start pin code activity  */
            //if (!isScreenOn) LockActivity.start(this)
    }

}