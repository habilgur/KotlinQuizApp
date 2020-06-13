package com.example.model

//Data Classes doesn't include functions but properties
data class Question(
    val id: Int,
    val question: String,
    val image: Int, //IMPORTANT: Images in Resources refers to an integer. Can call it with Integers
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: Int
)