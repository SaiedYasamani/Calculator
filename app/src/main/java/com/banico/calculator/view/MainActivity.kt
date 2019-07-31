package com.banico.calculator.view

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.banico.calculator.R
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAppWindow()
    }

    private fun setAppWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorPrimary, null)
            window.navigationBarColor = resources.getColor(R.color.colorPrimary, null)
        }
    }
}
