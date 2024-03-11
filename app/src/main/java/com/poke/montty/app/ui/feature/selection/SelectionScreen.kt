package com.poke.montty.app.ui.feature.selection

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.poke.montty.app.R
import com.poke.montty.app.ui.components.PokeButton
import com.poke.montty.app.ui.components.PokeToolbar
import com.poke.montty.app.ui.theme.PokeSetUp
import com.poke.montty.app.ui.theme.PokeTheme
import com.poke.montty.app.ui.theme.PokemonTheme
import kotlin.math.absoluteValue

@Preview
@Composable
fun SelectionScreenPreview() {
    PokeTheme {
        SelectionScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectionScreen() {
    Scaffold(
        topBar = {
            PokeToolbar(
                title = "Selecciona un pokemon"
            )
        },
        bottomBar = {
            PokeButton(text = "OK")
        }
    ) {


        val pokes = listOf(
            Pair(PokeTheme.PIKACHU, R.drawable.pikachu),
            Pair(PokeTheme.SQUIRTLE, R.drawable.squirtle),
            Pair(PokeTheme.BULBASAUR, R.drawable.bulbasaur)
        )

        val pagerState = rememberPagerState(pageCount = {
            pokes.size
        })

        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                PokeSetUp.setPokeTheme(pokes[page].first)
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {

            HorizontalPager(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                state = pagerState
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            // We animate the alpha, between 10% and 100%
                            alpha = lerp(
                                start = 0.1f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    chosePoke(
                        modifier = Modifier.align(Alignment.Center),
                        resource = pokes[page].second
                    )
                }
            }

            Row(
                Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) PokemonTheme.colors.primary else Color.White
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .border(3.dp, Color.Black, CircleShape)
                            .size(20.dp)
                    )
                }
            }

        }


    }
}

@Composable
fun chosePoke(
    modifier: Modifier,
    resource: Int
) {
    Image(
        modifier = modifier
            .animateContentSize()
            .width(300.dp)
            .height(300.dp),
        painter = painterResource(id = resource),
        contentDescription = "Pikachu"
    )
}
