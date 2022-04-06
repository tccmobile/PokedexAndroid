package com.example.pokedex

sealed class PokemonScreens(val route: String) {
    object HomeScreen: PokemonScreens("home")
    object DetailScreen: PokemonScreens("detail")
}