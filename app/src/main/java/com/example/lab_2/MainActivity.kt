package com.example.lab_2
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Activity1 : AppCompatActivity() {

    companion object {
        const val RESULT_CODE = 1
        const val RESULT_KEY = "result_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonCheck: Button = findViewById(R.id.buttonCheck)
        val editTextInput: EditText = findViewById(R.id.editTextInput)
        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val textViewFromActivity2: TextView = findViewById(R.id.textViewFromActivity2)

        buttonCheck.setOnClickListener {
            val inputText = editTextInput.text.toString()
            val result = calculateResult(inputText)

            textViewResult.text = result // Display result on Activity1

            val intent = Intent(this, activity1::class.java).apply {
                putExtra(Activity1.RESULT_KEY, result)
            }
            startActivityForResult(intent, Activity1.RESULT_CODE)



    }
}
    private fun calculateResult(input: String): String {
        return when {
            input.isEmpty() -> "No Value"
            input.matches("-?\\d+(\\.\\d+)?".toRegex()) -> {
                val number = input.toIntOrNull()
                when {
                    number == null -> "No Number"
                    number % 2 == 0 -> "Even Number"
                    else -> "Odd Number"
                }
            }
            else -> "Text"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RESULT_CODE && resultCode == RESULT_OK) {
            val result = data?.getStringExtra(RESULT_KEY)
            findViewById<TextView>(R.id.textViewFromActivity2).text = result
        }
    }
}