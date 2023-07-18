package com.savr.extensionlibrary

import android.app.Activity
import android.graphics.Color
import android.view.View
import androidx.core.view.WindowCompat

object ActivityExt {
    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Activity.isColorDark(color:Int) : Boolean{
        val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness >= 0.5
    }

    fun Activity.setStatusBarColor(color:Int){
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
            window?.statusBarColor = color
        }
    }

    fun Activity.toast(message: String, isLong: Boolean = false) {

    }
}
