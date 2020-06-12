package com.example.kotlinquizapp


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.constants.Constants
import com.example.model.Question
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var currentQuestionPosition: Int = 0
    private var questionsList: ArrayList<Question>? = null
    private var selectedAnswer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        questionsList = Constants.getQusetions()
        setQuestion()

        tvOpt1.setOnClickListener(this)
        tvOpt2.setOnClickListener(this)
        tvOpt3.setOnClickListener(this)
        tvOpt4.setOnClickListener(this)

        btSubmit.setOnClickListener {
            submit(questionsList!![currentQuestionPosition])
        }

    }

    private fun setQuestion() {

        var question = questionsList!![currentQuestionPosition]
        tvQuestionProgress.text = "$currentQuestionPosition / ${progressBar.max}"

        tvQuestionText.text = question.question
        tvOpt1.text = question.option1
        tvOpt2.text = question.option2
        tvOpt3.text = question.option3
        tvOpt4.text = question.option4


    }

    override fun onClick(v: View?) {
        var tvOpt = v as TextView
        when (tvOpt.id) {
            R.id.tvOpt1 -> selectedOptionView(tvOpt, 1)
            R.id.tvOpt2 -> selectedOptionView(tvOpt, 2)
            R.id.tvOpt3 -> selectedOptionView(tvOpt, 3)
            R.id.tvOpt4 -> selectedOptionView(tvOpt, 4)

        }
    }

    private fun selectedOptionView(tvOpt: TextView, num: Int) {
        resetOptionsView()
        selectedAnswer = num
        tvOpt.setTextColor(Color.parseColor("#36E36e"))
        tvOpt.background = ContextCompat.getDrawable(
            this
            , R.drawable.selected_option_border_bg
        )
    }


    private fun submit(question: Question) {
        if (selectedAnswer == question.correctAnswer) {
            Toast.makeText(this, "Hurraayyy", Toast.LENGTH_LONG).show()
            currentQuestionPosition++

        } else
            Toast.makeText(this, "BUUUUUUUU", Toast.LENGTH_LONG).show()
    }

    private fun resetOptionsView() {

        tvOpt1.setTextColor(Color.parseColor("#000000"))
        tvOpt1.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        tvOpt2.setTextColor(Color.parseColor("#000000"))
        tvOpt2.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        tvOpt3.setTextColor(Color.parseColor("#000000"))
        tvOpt3.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        tvOpt4.setTextColor(Color.parseColor("#000000"))
        tvOpt4.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

    }
}
