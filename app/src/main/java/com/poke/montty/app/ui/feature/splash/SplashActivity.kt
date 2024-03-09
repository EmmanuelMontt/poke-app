package com.poke.montty.app.ui.feature.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.poke.montty.app.ui.feature.main.MainActivity
import com.poke.montty.app.ui.feature.selection.SelectionActivity

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, SelectionActivity::class.java))
        finish()
    }

}
