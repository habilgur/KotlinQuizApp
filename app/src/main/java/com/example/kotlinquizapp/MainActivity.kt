package com.example.kotlinquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // In UI Activity, Remove top status bar on screen
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}
