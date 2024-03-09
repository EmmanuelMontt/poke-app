package com.poke.montty.app.ui.feature.selection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poke.montty.app.R
import com.poke.montty.app.ui.components.PokeButton
import com.poke.montty.app.ui.components.PokeToolbar
import com.poke.montty.app.ui.theme.PokeSetUp
import com.poke.montty.app.ui.theme.PokeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Preview
@Composable
fun SelectionScreenPreview() {
    PokeTheme {
        SelectionScreen()
    }
}

@Composable
fun SelectionScreen() {
    Scaffold(
        topBar = {
            PokeToolbar()
        },
        bottomBar = {
            PokeButton(text = "OK")
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = "Selecciona un pokemon",
                    fontSize = 30.sp
                )
            }

            item {
                chosePoke(
                    theme = PokeTheme.PIKACHU,
                    resource = R.drawable.pikachu
                )
            }

            item {
                chosePoke(
                    theme = PokeTheme.SQUIRTLE,
                    resource = R.drawable.squirtle
                )
            }

            item {
                chosePoke(
                    theme = PokeTheme.BULBASAUR,
                    resource = R.drawable.bulbasaur
                )
            }

        }
    }

}

@Composable
fun chosePoke(
    theme: PokeTheme,
    resource: Int
) {
    val width = 180.dp
    var expanded by remember { mutableStateOf(false) }


    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    CoroutineScope(Dispatchers.Default).launch {
        // Simulate loading data
        delay(500)

        // Update data on the main thread
        withContext(Dispatchers.Main) {
            visible = true
        }
    }

    AnimatedVisibility(
        visible = visible,
        enter =  fadeIn(
            initialAlpha = 0.0f
        )
    ) {
        Image(
            modifier = Modifier
                .animateContentSize()
                .width(if (expanded) 230.dp else width)
                .height(if (expanded) 230.dp else width)
                .padding(horizontal = 20.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    PokeSetUp.setPokeTheme(theme)
                    expanded = !expanded
                },
            painter = painterResource(id = resource),
            contentDescription = "Pikachu"
        )
    }


}
