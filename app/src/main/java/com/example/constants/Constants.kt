package com.example.constants

import com.example.kotlinquizapp.R
import com.example.model.Question

object Constants {

    fun getQusetions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Where is this flag belong to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Peru",
            "Turkey",
            "England",
            1
        )
        val que2 = Question(
            2,
            "Where is this flag belong to ?",
            R.drawable.ic_flag_of_australia,
            "Greece",
            "Australia",
            "Turkey",
            "England",
            2
        )
        val que3 = Question(
            3,
            "Where is this flag belong to ?",
            R.drawable.ic_flag_of_belgium,
            "Spain",
            "Australia",
            "Belgium",
            "England",
            3
        )

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        return questionList


    }
}