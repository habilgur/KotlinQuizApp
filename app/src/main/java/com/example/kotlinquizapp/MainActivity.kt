package com.example.kotlinquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // In UI Activity, Remove top status bar on screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btSubmit.setOnClickListener {
            if (etName.text.isNullOrEmpty())
                Toast.makeText(this, "Please Write Your Name!", Toast.LENGTH_LONG).show()
            else{
                val intent= Intent(this,QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}
