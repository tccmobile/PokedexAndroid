package com.example.pokedex

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination="home"){
        composable("home"){
            Pokedex(navController=navController)
        }
        composable("detail/{pokemonID}",
        arguments = listOf(navArgument(name="pokemonID"){type= NavType.IntType })) { entry ->
            pokeDetail( navController=navController, entry.arguments?.getInt("pokemonID"))
        }
    }
}