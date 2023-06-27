package com.example.a1quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView=findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.tv_result)
        val btnFinish:Button=findViewById(R.id.btn_finish)

        tvName.text=intent.getStringExtra(constants.USER_NAME)


        val totalQuestions=intent.getIntExtra(constants.TOTAL_QUESTION,0)
        val correctAnswers=intent.getIntExtra(constants.CORRECT_ANSWERS,0)

        tvScore.text="Your Score is $correctAnswers out of 10"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
    }

    }
}