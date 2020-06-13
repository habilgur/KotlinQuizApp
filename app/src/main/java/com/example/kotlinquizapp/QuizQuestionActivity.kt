package com.example.kotlinquizapp


import android.content.Intent
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

    private var currentQuestionIndex: Int = 0
    private var questionsList: ArrayList<Question>? = null
    private var selectedAnswer = 0
    private var selectedOption: TextView? = null
    private var correctOption: TextView? = null
    private var userScore = 0


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
            submit(questionsList!![currentQuestionIndex], selectedOption!!)
        }

    }

    private fun setQuestion() {
        resetOptionsView()
        var question = questionsList!![currentQuestionIndex]
        tvQuestionProgress.text = "${currentQuestionIndex + 1}/ ${progressBar.max}"

        tvQuestionText.text = question.question
        ivFlag.setImageResource(question.image)
        tvOpt1.text = question.option1
        tvOpt2.text = question.option2
        tvOpt3.text = question.option3
        tvOpt4.text = question.option4


    }

    // With Interface to assigned to class we can override OnClick Functions and used it with "this" mark in SetOnClickListeners where needed.
    override fun onClick(v: View?) {
        var tvOpt = v as TextView
        when (tvOpt.id) {
            R.id.tvOpt1 -> selectedOptionView(tvOpt, 1)
            R.id.tvOpt2 -> selectedOptionView(tvOpt, 2)
            R.id.tvOpt3 -> selectedOptionView(tvOpt, 3)
            R.id.tvOpt4 -> selectedOptionView(tvOpt, 4)

        }
    }

    private fun selectedOptionView(tvOpt: TextView, userAnswer: Int) {
        resetOptionsView()
        selectedAnswer = userAnswer
        selectedOption = tvOpt
        tvOpt.setTextColor(Color.parseColor("#36E36e"))
        tvOpt.background = ContextCompat.getDrawable(
            this
            , R.drawable.selected_option_border_bg
        )
    }


    private fun submit(question: Question, selectedoption: TextView) {


        when (btSubmit.text) {
            "SUBMIT" -> {
                if (selectedAnswer == question.correctAnswer) {
                    selectedoption.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_answer_bg)
                    userScore++
                    Toast.makeText(this, "Hurraayyy", Toast.LENGTH_LONG).show()

                } else {

                    selectedoption.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_answer_bg)
                    Toast.makeText(this, "BUUUUUUUU", Toast.LENGTH_LONG).show()
                }
                btSubmit.text = "GO TO NEXT"
            }
            "GO TO NEXT" -> {
                btSubmit.text = "SUBMIT"
                currentQuestionIndex++

                if (currentQuestionIndex == questionsList!!.size )
                    goToResultScreen()
                else
                    setQuestion()
            }

        }


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

    private fun goToResultScreen() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.SCORE, userScore)
        startActivity(intent)
    }
}
