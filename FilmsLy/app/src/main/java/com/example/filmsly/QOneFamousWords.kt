package com.example.filmsly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_question_one_famous_words.*

class QOneFamousWords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_one_famous_words)

        //get questions from constants
        val questionsList = Constants.getFamousWords()

        //set question number and array
        val questionNumber: Int = 1
        val question = questionsList[questionNumber - 1]

        //set UI elements to question 1
        tv_question.text = question.question
        rb_answer_one.text = question.optionOne
        rb_answer_two.text = question.optionTwo
        rb_answer_three.text = question.optionThree

        pb_progressBar.progress = questionNumber
        tv_progress.text = questionNumber.toString() + "/" + questionsList.size.toString()

        //set a button on click listener
        var answers: RadioButton
        var wordsCorrectAnswers: Int = 0

        btn_next.setOnClickListener{
            var id = rg_options.checkedRadioButtonId

            if(id != -1){
                //capture answer
                answers = findViewById(id)
                if (answers.text === question.optionOne){
                    wordsCorrectAnswers++
                    Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, QOneFamousWords2::class.java)
                intent.putExtra(Constants.WORDS_CORRECT_ANSWERS, wordsCorrectAnswers)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Your answer is incorrect", Toast.LENGTH_SHORT).show()
            }
        }

    }
}



