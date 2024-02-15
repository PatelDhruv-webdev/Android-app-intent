package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView


class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val result = intent.getStringExtra(Activity1.RESULT_KEY) ?: "No data received."
        val textViewResult: TextView = findViewById(R.id.textViewResult)
        textViewResult.text = result

        // Set the result to be returned to Activity1
        val returnIntent = Intent()
        returnIntent.putExtra(Activity1.RESULT_KEY, result)
        setResult(RESULT_OK, returnIntent)
    }
}