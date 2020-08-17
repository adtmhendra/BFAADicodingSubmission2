package com.hendra.githubuser.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.hendra.githubuser.MainActivity
import com.hendra.githubuser.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)

        val splashScreenAnim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_anim)

        splashScreenImage.animation = splashScreenAnim

        GlobalScope.launch {
            delay(5000)
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
        }
    }
}