package com.poke.montty.app.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun PokeTheme(
    content: @Composable () -> Unit
) {

    val pokeTheme by PokeSetUp.pokeTheme.collectAsState()

    PokemonTheme(
        colors = getColorsTheme(pokeTheme),
        content = content
    )
}

@Composable
internal fun PokemonTheme(
    colors: PokeColor,
    content: @Composable () -> Unit
) {
    
    CompositionLocalProvider(
        LocalPokeColor provides colors
    ) {
        content()
    }
}

object PokemonTheme {

    val colors: PokeColor
        @Composable @ReadOnlyComposable get() = LocalPokeColor.current

}
