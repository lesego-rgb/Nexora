package com.example.nexora

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.editText)
        val showButton = findViewById<Button>(R.id.btnCheck)
        val resetButton = findViewById<Button>(R.id.btnReset)
        val resultText = findViewById<TextView>(R.id.resultText)

        showButton.setOnClickListener {
            val input = timeInput.text.toString().trim().lowercase()

            val suggestion = when (input) {
                "morning" -> "Send a Good morning text to a family member."
                "mid-morning" -> "Reach out to a colleague with a quick Thank you."
                "afternoon" -> "Share a funny meme or interesting link with a friend."
                "afternoon snack time" -> "Send a quick thinking of you message."
                "dinner" -> "Call a friend or relative for a 5-minute catch-up."
                "night", "after dinner", "after dinner / night" -> "Leave a thoughtful comment on a friend's post."
                "" -> "Please enter a time of day."
                else -> "Invalid input. Please enter: morning, mid-morning, afternoon, afternoon snack time, dinner, or night."
            }

            resultText.text = suggestion
            Log.d("NexoraApp", "User entered: $input | Suggestion: $suggestion")
        }

        resetButton.setOnClickListener {
            timeInput.text.clear()
            resultText.text = "Your suggestion will appear here"
            Log.d("NexoraApp", "Input and result cleared")
        }
    }
}
