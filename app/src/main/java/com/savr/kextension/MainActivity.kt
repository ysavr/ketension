package com.savr.kextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.savr.extensionlibrary.hideKeyboard
import com.savr.extensionlibrary.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}