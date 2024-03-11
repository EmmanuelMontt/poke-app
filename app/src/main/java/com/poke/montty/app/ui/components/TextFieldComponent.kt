package com.poke.montty.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.poke.montty.app.ui.theme.PokeSetUp
import com.poke.montty.app.ui.theme.PokeTheme

@Preview
@Composable
fun PokeOutlinedTextFieldPreview(
    @PreviewParameter(ThemeProvider::class) theme: PokeTheme
) {
    PokeSetUp.setPokeTheme(theme)
    PokeTheme {
        Column {
            PokeTextField()
            PokeOutlinedTextField()
        }
    }
}

@Composable
fun PokeTextField() {

    var text by remember { mutableStateOf("Hello") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )

}

@Composable
fun PokeOutlinedTextField() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )

}
