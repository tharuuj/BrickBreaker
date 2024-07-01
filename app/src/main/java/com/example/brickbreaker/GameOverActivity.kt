package com.example.brickbreaker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameOverActivity : AppCompatActivity() {

    private lateinit var scoreTextView: TextView
    private lateinit var highestScoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        scoreTextView = findViewById(R.id.scoreTextView)
        highestScoreTextView = findViewById(R.id.highestScoreTextView)
        val restartButton = findViewById<Button>(R.id.restartButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val score = intent.getIntExtra("score", 0)
        val highestScore = getHighScore()

        scoreTextView.text = "Score: $score"
        highestScoreTextView.text = "Highest Score: $highestScore"

        restartButton.setOnClickListener {
            // Restart the game by going back to MainActivity
            val intent = Intent(this@GameOverActivity, MainActivity::class.java)
            startActivity(intent)

            finish()
        }

        exitButton.setOnClickListener {
            // Exit the app
            finishAffinity()
        }
    }

    // Function to get high score from SharedPreferences
    private fun getHighScore(): Int {
        val sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getInt(KEY_HIGH_SCORE, 0)
    }

    companion object {
        private const val PREFS_NAME = "BrickBreakerPrefs"
        private const val KEY_HIGH_SCORE = "highScore"
    }
}