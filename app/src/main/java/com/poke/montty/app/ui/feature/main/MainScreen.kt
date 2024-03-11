package com.poke.montty.app.ui.feature.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.poke.montty.app.ui.components.DemoItems
import com.poke.montty.app.ui.components.PokeToolbar
import com.poke.montty.app.ui.theme.PokeTheme

@Preview
@Composable
fun MainScreenPreview() {
    PokeTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            PokeToolbar()
        }
    ) { padding ->
        DemoItems(paddingValues = padding)
    }
}
