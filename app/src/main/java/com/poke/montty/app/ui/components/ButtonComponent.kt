package com.poke.montty.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poke.montty.app.ui.theme.PokeSetUp
import com.poke.montty.app.ui.theme.PokeTheme
import com.poke.montty.app.ui.theme.PokemonTheme

@Preview
@Composable
fun PokeButtonPreview(
    @PreviewParameter(ThemeProvider::class) theme: PokeTheme
) {
    PokeSetUp.setPokeTheme(theme)
    PokeTheme {
        LazyColumn {
            item {
                PokeButton(text = "Button")
            }
            item {
                PokeFilledButton(text = "Filled")
            }
            item {
                PokeOutlinedButton(text = "Outlined")
            }
            item {
                PokeElevatedButton(text = "Elevated")
            }
            item {
                PokeTextButton(text = "Text")
            }
        }
    }
}

@Composable
fun PokeButton(
    modifier: Modifier = Modifier,
    text: String
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(vertical = 8.dp)
            .then(modifier),
        onClick = {

        },
        colors = ButtonDefaults.buttonColors(
            containerColor = PokemonTheme.colors.primary,
            contentColor = PokemonTheme.colors.textPrimary
        )
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun PokeFilledButton(
    modifier: Modifier = Modifier,
    text: String
) {
    FilledTonalButton(
        modifier = modifier,
        onClick = {

        },
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = PokemonTheme.colors.secondary,
            contentColor = PokemonTheme.colors.textSecondary
        )
    ) {
        Text(text)
    }
}

@Composable
fun PokeOutlinedButton(
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedButton(
        modifier = modifier,
        onClick = {

        },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = PokemonTheme.colors.secondary
        ),
        border = BorderStroke(
            width = 1.dp,
            color = PokemonTheme.colors.secondary,
        )
    ) {
        Text(text)
    }
}

@Composable
fun PokeElevatedButton(
    modifier: Modifier = Modifier,
    text: String
) {
    ElevatedButton(
        modifier = modifier,
        onClick = {

        },
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = PokemonTheme.colors.tertiary,
            contentColor = PokemonTheme.colors.textTertiary
        )
    ) {
        Text(text)
    }
}

@Composable
fun PokeTextButton(
    modifier: Modifier = Modifier,
    text: String
) {
    TextButton(
        modifier = modifier,
        onClick = {

        },
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.White,
            contentColor = PokemonTheme.colors.secondary
        )
    ) {
        Text(text)
    }
}
