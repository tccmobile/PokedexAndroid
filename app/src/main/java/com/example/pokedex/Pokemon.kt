package com.example.pokedex

data class Pokemon(
    val id: Int = 0,
    val name: String = "Bulbasaur",
    val imageURL: String = "bulb",
    val type: String = "poison",
    val weight: Double = 15.0,
    val height: Double = 80.0,
    val description: String = "Our first pokemon",
    val attack: Double = 30.0,
    val defence: Double = 30.0
)
