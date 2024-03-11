package com.poke.montty.app.ui.components

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.poke.montty.app.ui.theme.PokeTheme

class ThemeProvider : PreviewParameterProvider<PokeTheme> {
    override val values: Sequence<PokeTheme>
        get() = sequenceOf(
            PokeTheme.PIKACHU,
            PokeTheme.BULBASAUR,
            PokeTheme.SQUIRTLE
        )

}