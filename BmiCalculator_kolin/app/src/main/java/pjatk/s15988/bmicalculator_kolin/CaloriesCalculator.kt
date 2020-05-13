package pjatk.s15988.bmicalculator_kolin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calories_calculator.*
import kotlinx.android.synthetic.main.activity_main.*

class CaloriesCalculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_calculator)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender,
            R.layout.support_simple_spinner_dropdown_item
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        gender_spinner.setAdapter(adapter)

        calculateCalories.setOnClickListener(){
            if (ageTextEdit.getText().length > 0 && weightTextEdit.text.length > 0 && heightTextEdit.text.length > 0) {
                calculateCaloriesVariants()
            } else {
                Toast.makeText(this@CaloriesCalculator, R.string.data_warning, Toast.LENGTH_LONG).show()
            }
        }

    }

    fun calculateCaloriesVariants(){
        when(gender_spinner.selectedItem){
            "Kobieta"-> resultCalories.text = calculateFormulaFemale().toString()
            "Mężczyzna" -> resultCalories.text = calculateFormulaMale().toString()

        }
    }


    fun calculateFormulaMale(): Double{
        return ((655.1 + 9.563 * weightTextEdit.getText().toString().toDouble()
                + 1.85 * heightTextEdit.getText().toString().toDouble())
                - 4.676 * ageTextEdit.getText().toString().toDouble())
    }

    fun calculateFormulaFemale(): Double{
        return ((66.5 + 13.75 * weightTextEdit.getText().toString().toDouble()
                + 5.003 * heightTextEdit.getText().toString().toDouble())
                - 6.775 * ageTextEdit.getText().toString().toDouble())
    }
}
