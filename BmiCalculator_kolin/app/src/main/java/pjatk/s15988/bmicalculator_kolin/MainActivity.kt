package pjatk.s15988.bmicalculator_kolin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener(){
            checkBMIrange(calculate())
        }
    }

     fun calculate(): Double {
        val weightFromForm: Double
        val heightFromForm: Double
        weightFromForm = weight.text.toString().toDouble()
        heightFromForm = height.text.toString().toDouble()
        return weightFromForm / Math.pow(heightFromForm / 100, 2.0)
    }

    fun checkBMIrange(bmi: Double) {
        if (bmi < 16) {
            Toast.makeText(applicationContext, getText(R.string.under_16), Toast.LENGTH_SHORT)
                .show()
        } else if (bmi > 16.00 && bmi <= 16.99) {
            Toast.makeText(
                applicationContext,
                getText(R.string.bmi_16_to_17),
                Toast.LENGTH_SHORT
            ).show()
        } else if (bmi > 17 && bmi <= 18.49) {
            Toast.makeText(
                applicationContext,
                getText(R.string.bmi_17_to_18_and_half),
                Toast.LENGTH_SHORT
            ).show()
        } else if (bmi > 18.50 && bmi <= 25) {
            Toast.makeText(
                applicationContext,
                getText(R.string.bmi_18_and_half_to_25),
                Toast.LENGTH_SHORT
            ).show()
        } else if (bmi > 25 && bmi <= 30) {
            Toast.makeText(
                applicationContext,
                getText(R.string.bmi_25_to_30),
                Toast.LENGTH_SHORT
            ).show()
        } else if (bmi > 30 && bmi <= 35) {
            Toast.makeText(
                applicationContext,
                getText(R.string.bmi_30_to_35),
                Toast.LENGTH_SHORT
            ).show()
        } else if (bmi >= 40) {
            Toast.makeText(
                applicationContext,
                getText(R.string.more_than_40),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
