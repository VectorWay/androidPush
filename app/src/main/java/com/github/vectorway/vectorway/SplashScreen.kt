package com.github.vectorway.vectorway

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        routeToOtherActivity()
        finish()
    }

    private fun routeToOtherActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
