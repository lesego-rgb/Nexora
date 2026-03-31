package com.example.nexora

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //I have created Views
        val timeInput = findViewById<AutoCompleteTextView>(R.id.editText)
        val showButton = findViewById<Button>(R.id.btnCheck)
        val resetButton = findViewById<Button>(R.id.btnReset)
        val resultText = findViewById<TextView>(R.id.resultText)

        // 2. Setup the Suggestions List
        val suggestions = arrayOf(
            "Morning", "Mid-morning", "Afternoon",
            "Afternoon snack time", "Dinner", "Night"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, suggestions)
        timeInput.setAdapter(adapter)

        // Suggestion
        showButton.setOnClickListener {
            val input = timeInput.text.toString().trim().lowercase()

            val suggestion = when (input) {
                "morning" -> "Send a Good morning text to a family member."
                "mid-morning" -> "Reach out to a colleague with a quick Thank you."
                "afternoon" -> "Share a funny meme or interesting link with a friend."
                "afternoon snack time" -> "Send a quick thinking of you message."
                "dinner" -> "Call a friend or relative for a 5-minute catch-up."
                "night", "after dinner" -> "Leave a thoughtful comment on a friend's post."
                "" -> "Please enter a time of day."
                else -> "Invalid input. Please try using the suggestions!"
            }

            resultText.text = suggestion
            Log.d("NexoraApp", "User entered: $input")
        }

        //  Reset button
        resetButton.setOnClickListener {
            timeInput.text.clear()
            resultText.text = "Your suggestion will appear here"
            Log.d("NexoraApp", "UI Reset")
        }
    }
}