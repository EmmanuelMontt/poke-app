package com.poke.montty.app.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * https://www.color-name.com/
 */

val LocalPokeColor = compositionLocalOf { pikachuColors() }

data class PokeColor(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val error: Color,
    val background: Color,
    val outline: Color,
    val surface: Color
)

fun pikachuColors(): PokeColor =
    PokeColor(
        primary = Color(0XFFffe62d),
        secondary = Color(0XFFe92929),
        tertiary = Color(0XFF000000),
        textPrimary = Color(0XFF000000),
        textSecondary = Color(0XFFFFFFFF),
        textTertiary = Color(0XFFFFFFFF),
        error = Color(0XFFe92929),
        background = Color(0XFFFFFFFF),
        outline = Color(0XFF000000),
        surface = Color(0XFFfffbff)
    )

fun bulbasaurColors(): PokeColor =
    PokeColor(
        primary = Color(0XFF83ba36),
        secondary = Color(0XFF378e8e),
        tertiary = Color(0XFF2a513f),
        textPrimary = Color(0XFF000000),
        textSecondary = Color(0XFFFFFFFF),
        textTertiary = Color(0XFFFFFFFF),
        error = Color(0XFFe92929),
        background = Color(0XFFFFFFFF),
        outline = Color(0XFF000000),
        surface = Color(0XFFfffbff)
    )

fun squirtleColors(): PokeColor =
    PokeColor(
        primary = Color(0XFF93c8d0),
        secondary = Color(0XFF297383),
        tertiary = Color(0XFFca7721),
        textPrimary = Color(0XFF000000),
        textSecondary = Color(0XFFFFFFFF),
        textTertiary = Color(0XFFFFFFFF),
        error = Color(0XFFe92929),
        background = Color(0XFFFFFFFF),
        outline = Color(0XFF000000),
        surface = Color(0XFFfffbff)
    )
