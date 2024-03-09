package com.poke.montty.app.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.poke.montty.app.ui.theme.PokeTheme

@Preview
@Composable
fun PikachuThemePreview(
    @PreviewParameter(ThemeProvider::class) theme: PokeTheme
) {
    PokeTheme {
        DemoTheme()
    }
}

@Composable
fun DemoTheme() {
    Scaffold(
        topBar = {
            PokeToolbar()
        }
    ) { padding ->

        DemoItems(paddingValues = padding)

    }
}

@Composable
fun DemoItems(
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(30.dp)
    ) {
        item {
            Text(text = "Hola")
        }

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

        item {
            PokeTextField()
        }

        item {
            PokeOutlinedTextField()
        }

        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)
            ) {
                Text(
                    text = "Filled",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }

        item {
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)
            ) {
                Text(
                    text = "Outlined",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}