package com.poke.montty.app.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.poke.montty.app.ui.theme.PokeSetUp
import com.poke.montty.app.ui.theme.PokeTheme
import com.poke.montty.app.ui.theme.PokemonTheme

@Preview
@Composable
fun PokeToolbarPreview(
    @PreviewParameter(ThemeProvider::class) theme: PokeTheme
) {
    PokeSetUp.setPokeTheme(theme)
    PokeTheme {
        Scaffold(
            topBar = {
                PokeToolbar()
            }
        ) {

            LazyColumn(modifier = Modifier.padding(it)) {
                item {
                    Text(text = theme.name)
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeToolbar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PokemonTheme.colors.primary,
        ),
        title = {
            Text("Tertiary")
        }
    )
}
