package com.poke.montty.app.ui.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object PokeSetUp {

    private val _pokeTheme = MutableStateFlow(PokeTheme.PIKACHU)
    val pokeTheme get() = _pokeTheme.asStateFlow()

    fun setPokeTheme(pokeTheme: PokeTheme) {
        _pokeTheme.value = pokeTheme
    }

}

enum class PokeTheme {
    PIKACHU,
    BULBASAUR,
    SQUIRTLE
}

fun getColorsTheme(pokemon: PokeTheme) =
    when (pokemon) {
        PokeTheme.PIKACHU -> pikachuColors()
        PokeTheme.BULBASAUR -> bulbasaurColors()
        PokeTheme.SQUIRTLE -> squirtleColors()
    }
