package com.example.brickbreaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView

class LaunchScreen : AppCompatActivity() {

    private lateinit var bricksbreak: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)



        Handler(Looper.getMainLooper()).postDelayed({
            // Create an Intent to start MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish IntroductoryActivity
        }, 4000) // 4000 milliseconds delay

    }
}