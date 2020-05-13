package pjatk.s15988.bmicalculator_kolin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        buttonCalories.setOnClickListener(){
            runCaloriesCalculator()
        }
        buttonBMI.setOnClickListener(){
            runBmiCalculator()
        }
        buttonQuiz.setOnClickListener(){
            runQuizGame()
        }
        gameButton.setOnClickListener(){

        }
    }

    private fun runQuizGame() {
        val quiz = Intent(this, CoronavirusQuiz::class.java)
        startActivity(quiz)
    }

    fun runCaloriesCalculator(){
        val calories = Intent(this, CaloriesCalculator::class.java)
        startActivity(calories)
    }
    fun runBmiCalculator(){
        val bmi = Intent(this, MainActivity::class.java)
        startActivity(bmi)
    }

}
