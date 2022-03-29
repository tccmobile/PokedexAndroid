package com.example.pokedex

import com.example.pokedex.ui.theme.PokedexTheme

data class Pokemon(
    val id: Int = 1,
    val name: String = "Bulbasaur",
    val imageURL: String = "bulb",
    val type: String = "poison",
    val weight: Double = 15.0,
    val height: Double = 80.0,
    val description: String = "Our first pokemon",
    val attack: Double = 30.0,
    val defence: Double = 30.0
)


val mockPokedex =  mutableListOf<Pokemon>(Pokemon(),
    Pokemon(1,"Ivysaur"),Pokemon
(3,"Charmander", type = "fire"))