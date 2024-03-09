package com.poke.montty.app.ui.feature.selection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import com.poke.montty.app.R
import com.poke.montty.app.ui.feature.main.MainScreen
import com.poke.montty.app.ui.theme.PokeTheme

class SelectionActivity  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeTheme {
                SelectionScreen()
            }
        }
    }

}