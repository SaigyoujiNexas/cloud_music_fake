package com.saigyouji.cloudmusic.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.saigyouji.cloudmusic.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        setImmersiveStatusBar()
        //show the main page not is login screen
    }
    //set the translucent status bar
    private fun setImmersiveStatusBar()
    {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}