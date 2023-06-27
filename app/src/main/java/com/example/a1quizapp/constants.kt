package com.example.a1quizapp

import java.util.ArrayList

object constants {

    const val USER_NAME:String="user_name"
    const val  TOTAL_QUESTION:String="total_question"
    const val  CORRECT_ANSWERS:String="correct_answers"

  public  fun getQuestion():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val que1=Question(
        1,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia","Armenia","Austria",1)
        questionList.add(que1)
        val que2=Question(
        2,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina","Australia","Armenia","Austria",2)
        questionList.add(que2)
        val que3=Question(
        3,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina","Australia","Armenia","Belgium",4)
        questionList.add(que3)
        val que4=Question(
        4,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina","Brazil","Armenia","Austria",2)
        questionList.add(que4)
        val que5=Question(
        5,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina","Australia","Denmark","Austria",3)
        questionList.add(que5)
        val que6=Question(
        6,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Argentina","Australia","Armenia","Germany",4)
        questionList.add(que6)
        val que7=Question(
        7,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India","Australia","Armenia","Belgium",1)
        questionList.add(que7)
        val que8=Question(
        8,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina","Kuwait","Armenia","Austria",2)
        questionList.add(que8)
        val que9=Question(
        9,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina","Fiji","Denmark","Austria",2)
        questionList.add(que9)
        val que10=Question(
        10,"Which country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Netherland","Australia","Denmark","Newzeland",4)
        questionList.add(que10)
        return questionList
    }
}

