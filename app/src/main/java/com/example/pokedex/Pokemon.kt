package com.example.pokedex

import android.os.Parcelable
import com.example.pokedex.ui.theme.PokedexTheme
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int = 1,
    val name: String = "Bulbasaur",
    //val imageResource: Int = R.drawable.bulb,
    val type: String = "poison",
    val weight: Double = 15.0,
    val height: Double = 80.0,
    val description: String = "Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun’s rays, the seed grows progressively larger.",
    val attack: Double = 30.0,
    val defense: Double = 30.0
) : Parcelable

/* val mockPokedex = mutableListOf<Pokemon>(
    Pokemon(),
    Pokemon(2,"Ivysaur", description = "There is a bud on this Pokémon’s back. To support its weight, Ivysaur’s legs and trunk grow thick and strong. If it starts spending more time lying in the sunlight, it’s a sign that the bud will bloom into a large flower soon."),
    Pokemon(3,"Venasaur", description = "There is a large flower on Venusaur’s back. The flower is said to take on vivid colors if it gets plenty of nutrition and sunlight. The flower’s aroma soothes the emotions of people."),
    Pokemon(4,"Charmander", type = "fire", description = "The flame that burns at the tip of its tail is an indication of its emotions. The flame wavers when Charmander is enjoying itself. If the Pokémon becomes enraged, the flame burns fiercely.")
)
*/

