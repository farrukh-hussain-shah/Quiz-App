package com.example.a1quizapp


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.a1quizapp.constants.getQuestion
import java.util.*


class QuizActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0

    private var mUserName:String?=null
    // In this we input the data from  mainactivity because we said that send to this activity Now we retrieve and send it ti next

    private var mCorrectAnswer:Int=0

            private var progressBar: ProgressBar?=null
            private var tvProgress:TextView?=null
            private var tvQuestion:TextView?=null
            private var ivImage: ImageView?=null

            private var tvOption1:TextView?=null
            private var tvOption2:TextView?=null
            private var tvOption3:TextView?=null
            private var tvOption4:TextView?=null
            private var btn_submit:Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mUserName=intent.getStringExtra(constants.USER_NAME)//TODO with this fun we called USER_NAME =>mUserName

        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)

        tvOption1=findViewById(R.id.tv_option1)
        tvOption2=findViewById(R.id.tv_option2)
        tvOption3=findViewById(R.id.tv_option3)
        tvOption4=findViewById(R.id.tv_option4)
        btn_submit=findViewById(R.id.btn_submit)

        mQuestionList = getQuestion()
        setQuestion()

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)

        btn_submit?.setOnClickListener(this)
    }// TODO "WE INPUT THE FUNTIONS THAT WE NEED"

    private fun setQuestion() {

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit?.text="Finish"
        }else {
            btn_submit?.text="Submit"
        }

        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        ivImage?.setImageResource(question.image)
        tvQuestion?.text = question.question
        tvOption1?.text = question.optionOne   //TODO "In thils we call the class question and input the question
        tvOption2?.text = question.optionTwo   //TODO "In thils we call the class question and input the opton 1
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour


    }
     fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tvOption1?.let {
            options.add(0,it)
        }
        tvOption2?.let {
            options.add(1,it)
        }
        tvOption3?.let {
            options.add(2,it)
        }
        tvOption4?.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
        //  option.setTextColor(Color.parseColor("#ff0000"))this is just used to color of options
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizActivity,
                R.drawable.default_option_border_bg
            )

        }
    }
    private fun selectedOptionView(tv:TextView,selectedOption:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this@QuizActivity,
            R.drawable.default_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tv_option1-> {
                tvOption1?.let {
                    selectedOptionView(it, 1)
                }

            }

            R.id.tv_option2 -> {
                tvOption2?.let {
                    selectedOptionView(it, 2)
                }

            }

            R.id.tv_option3 -> {
                tvOption3?.let {
                    selectedOptionView(it, 3)
                }

            }

            R.id.tv_option4 -> {
                tvOption4?.let {
                    selectedOptionView(it, 4)
                }

            }

            R.id.btn_submit->{

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else ->{
//                            Toast.makeText(this, "You Made it to the end ", Toast.LENGTH_SHORT).show() (THis is used early by that it is reached end them toast
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(constants.USER_NAME,mUserName)
                            intent.putExtra(constants.CORRECT_ANSWERS,mCorrectAnswer)
                            intent.putExtra(constants.TOTAL_QUESTION,mQuestionList?.size)
                            startActivity(intent)
                            finish()//we dont want to used jump to back



                        }

                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswer++
                    }
                    // TODO (STEP 2: Increase the count of correct answer by 1 if the answer is right.)
                    // START

                    // END
                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit?.text = "FINISH"
                    } else {
                        btn_submit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                    this@QuizActivity,
                    drawableView
                )
            }
            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this@QuizActivity,
                    drawableView
                )
            }
            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this@QuizActivity,
                    drawableView
                )
            }
            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this@QuizActivity,
                    drawableView
                )
            }
        }
    }

}