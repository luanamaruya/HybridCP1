package br.com.fiap.checkpoint01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val animationSplash = findViewById<LottieAnimationView>(R.id.animationSplash)
        animationSplash.playAnimation()
        goToMain()
    }

    private fun goToMain(){
        Timer().schedule(3000){
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(mIntent)
        }
    }
}