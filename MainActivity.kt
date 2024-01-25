package com.example.program2v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var ans1: TextView? = null
    var ans2: TextView? = null
    var ans3: TextView? = null
    var ans4: TextView? = null
    var ans5: TextView? = null
    var ans6: TextView? = null
    var ac: TextView? = null
    var guess: EditText? = null
    var butt: Button? = null
    var guessNum:Int = 1

    val words = WordleStuff ()
    var correct:String = words.randword();
    var goodWord:Boolean = false

    fun grader2(g:String,a:String):String {
        var editA:CharArray = a.toCharArray()
        var graded:String = ""
        for(i in 0 .. a.length-1) {
            if (g.uppercase()[i] == editA[i]) {
                graded += g.uppercase()[i] + " "
                for (j in 0 until a.length) {
                    if (g.uppercase()[i] == editA[j]) {
                        editA[j] = '?'
                    }
                }
            }
            else if(g.uppercase()[i] in editA) {
                graded += g.lowercase()[i] + " "
                for (j in 0 until a.length) {
                    if (g.uppercase()[i] == editA[j]) {
                        editA[j] = '?'
                    }
                }
            }
            else {
                graded += "_ "
            }
        }
        return graded
    }



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ans1 = findViewById (R.id.answer1)
        ans2 = findViewById (R.id.answer2)
        ans3 = findViewById (R.id.answer3)
        ans4 = findViewById (R.id.answer4)
        ans5 = findViewById (R.id.answer5)
        ans6 = findViewById (R.id.answer6)  
        ac = findViewById (R.id.answerCorrect)
        butt = findViewById (R.id.button)
        guess = findViewById (R.id.choice)

        butt!!.setOnClickListener {

            for (s in words.WordleWords) {
                if (s == guess!!.text.toString().uppercase()) {
                    goodWord = true
                }
            }
            if (guess!!.text.toString().length == 5 && goodWord) {
                ac!!.text = ""
                if (guessNum == 1) {
                    ans1!!.text = grader2(guess!!.text.toString(),correct)
                    if (guess!!.text.toString().uppercase() == correct) {
                        ac!!.text = "Got it in ${guessNum} try!"
                        butt!!.text = "RESET"
                        guessNum = 7
                    }
                }
                else if (guessNum == 2) {
                    ans2!!.text = grader2(guess!!.text.toString(),correct)
                    if (guess!!.text.toString().uppercase() == correct) {
                        ac!!.text = "Got it in ${guessNum} tries!"
                        butt!!.text = "RESET"
                        guessNum = 7
                    }
                }
                else if (guessNum == 3) {
                    ans3!!.text = grader2(guess!!.text.toString(),correct)
                    if (guess!!.text.toString().uppercase() == correct) {
                        ac!!.text = "Got it in ${guessNum} tries!"
                        butt!!.text = "RESET"
                        guessNum = 7
                    }
                }
                else if (guessNum == 4) {
                    ans4!!.text = grader2(guess!!.text.toString(),correct)
                    if (guess!!.text.toString().uppercase() == correct) {
                        ac!!.text = "Got it in ${guessNum} tries!"
                        butt!!.text = "RESET"
                        guessNum = 7
                    }
                }
                else if (guessNum == 5) {
                    ans5!!.text = grader2(guess!!.text.toString(),correct)
                    if (guess!!.text.toString().uppercase() == correct) {
                        ac!!.text = "Got it in ${guessNum} tries!"
                        butt!!.text = "RESET"
                        guessNum = 7
                    }
                }
                else if (guessNum == 6 && guess!!.text.toString().uppercase() == correct) {
                    ans6!!.text = grader2(guess!!.text.toString(),correct)
                    ac!!.text = "Got it in ${guessNum} tries!"
                    butt!!.text = "RESET"
                    guessNum = 7
                }
                else if (guessNum == 6 && guess!!.text.toString().uppercase() != correct){
                    ans6!!.text = grader2(guess!!.text.toString(),correct)
                    ac!!.text = "Yikes, you suck! It was '$correct'"
                    butt!!.text = "RESET"
                    guessNum = 7
                }
                else {
                    guessNum = 0
                    ans1!!.text = "_ _ _ _ _ "
                    ans2!!.text = "_ _ _ _ _ "
                    ans3!!.text = "_ _ _ _ _ "
                    ans4!!.text = "_ _ _ _ _ "
                    ans5!!.text = "_ _ _ _ _ "
                    ans6!!.text = "_ _ _ _ _ "
                    correct = words.randword()
                    butt!!.text = "GUESS!"
                    ac!!.text = ""
                }
                guessNum++
            }
            else {
                ac!!.text = "Not a valid guess, try again"
            }
            goodWord = false
        }



    }



}