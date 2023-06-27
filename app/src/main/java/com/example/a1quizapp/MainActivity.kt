package com.example.a1quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart: Button=findViewById(R.id.btnStart)
        val etName: EditText=findViewById(R.id.etName)
        btnStart.setOnClickListener(){
            if(etName.text.isEmpty()){
                Toast.makeText(this,"Kindly Enter The Name First",Toast.LENGTH_LONG).show()

            }
            else {val intent= Intent(this,QuizActivity::class.java)
//                TODO IT USED TO TRASFER DATA FROM ONE ACTIVITY TO ANOTHER
                intent.putExtra(constants.USER_NAME,etName.text.toString())
//                IF YOU don't want to share data from one activity to another then you dont put this line "intent.putExtra"
                startActivity(intent)

                finish() }
        }
    }
}
