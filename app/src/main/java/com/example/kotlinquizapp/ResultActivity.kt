package com.example.kotlinquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    companion object{
        const val RESULT_ACTIVITY_CODE=1

        const val SCORE="Score"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val extras= intent.extras
        if(extras!=null){
            val score= extras.getInt(SCORE)
            tv_result.text="Your Result is:$score"
        }

        bt_Restart.setOnClickListener {
            val intent=Intent(this,QuizQuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



}
