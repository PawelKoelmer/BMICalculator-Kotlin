package pjatk.s15988.bmicalculator_kolin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_coronavirus_quiz.*
import kotlinx.android.synthetic.main.end_quiz.*
import kotlinx.android.synthetic.main.game_layout.*
import java.util.*
import kotlin.collections.ArrayList


class CoronavirusQuiz : AppCompatActivity() {

    var usedNumbers = ArrayList<Int>()
    var points = 0
    var q = 0
    var questionList = ArrayList<String>()
    var answersList = ArrayList<ArrayList<String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareGame()
    }

    private fun prepareGame() {
        setContentView(R.layout.activity_coronavirus_quiz)
        StartButton.setOnClickListener(){
            startGame()
        }
    }

    private fun startGame() {
        setContentView(R.layout.game_layout)
        setArrays()
        startQuiz()
    }

    private fun startQuiz() {

        button1.setOnClickListener(){checkRound(1)}
        button2.setOnClickListener(){checkRound(2)}
        button3.setOnClickListener(){checkRound(3)}
        button4.setOnClickListener(){checkRound(4)}

        startRound()
    }

    private fun startRound() {
        q = Random().nextInt(6)
        if (!usedNumbers.contains(q)) {
            usedNumbers.add(q)
            questionView.setText(questionList.get(q))
            button1.setText(answersList.get(q).get(0).replace("_"," "))
            button2.setText(answersList.get(q).get(1).replace("_"," "))
            button3.setText(answersList.get(q).get(2).replace("_"," "))
            button4.setText(answersList.get(q).get(3).replace("_"," "))
        } else {
            startRound()
        }
    }

    private fun checkRound(i: Int) {
        if (usedNumbers.size < 6 && i == answersList.get(q).get(4).toInt()) {
            points += 1
            startRound()
        } else if (usedNumbers.size < 6 && i != answersList.get(q).get(4).toInt()) {
            startRound()
        } else if (usedNumbers.size == 6) {
            endOfGame()
        }
    }

    private fun endOfGame() {
        setContentView(R.layout.end_quiz)
        endGameTextView.setText(getText(R.string.points).toString() + points + " / " + questionList.size.toString())

        restartQuizButton.setOnClickListener(){
            val intent = intent
            finish()
            startActivity(intent)
        }
        endGameButton.setOnClickListener(){
            finish()
        }
    }

    private fun setArrays() {
        resources.getStringArray(R.array.Questions).forEach { questionList.add(it) }
        resources.getStringArray(R.array.QuestionAnswers).forEach {
            var itTrimed =  it.replace(" ","")
            val answers: ArrayList<String> = itTrimed.split(";") as ArrayList<String>
            answersList.add(answers)
        }
    }
}
