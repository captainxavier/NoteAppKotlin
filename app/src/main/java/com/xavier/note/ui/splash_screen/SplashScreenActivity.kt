package com.xavier.note.ui.splash_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.xavier.note.R
import com.xavier.note.ui.home.HomeActivity
import com.xavier.note.view_model.SplashViewModel
import kotlinx.android.synthetic.main.layout_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private val TAG = SplashScreenActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_splash_screen)
        Log.d(TAG, "onCreate: started")
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val firstTimeUser = sharedPref.getBoolean(getString(R.string.first_time_user), true)

        if (!firstTimeUser){
            Log.d(TAG, "onCreate: first time")
            with (sharedPref.edit()) {
                putBoolean(getString(R.string.first_time_user), false)
                apply()
                getStarted()
            }            
        }else{
            Log.d(TAG, "onCreate: not first time")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getStarted() {
        btnStarted.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}