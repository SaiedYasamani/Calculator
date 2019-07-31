package com.banico.calculator.view

import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.banico.calculator.R
import androidx.appcompat.app.AppCompatActivity
import com.banico.calculator.dagger.AppComponent
import com.banico.calculator.dagger.AppModule
import com.banico.calculator.dagger.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    var component: AppComponent? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAppWindow()
        setDagger()
    }

    private fun setAppWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorPrimary, null)
            window.navigationBarColor = resources.getColor(R.color.colorPrimary, null)
        }
    }

    private fun setDagger() {
        component = DaggerAppComponent.builder().appModule(AppModule(application)).build()
        component!!.inject(application)
    }
}
