package com.example.pokedex

import android.content.Context
import android.util.Log
import com.example.pokedex.MainActivity.Companion.mycontext
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun getJsonDataFromAsset(fileName: String): String? {
    val jsonString: String
    try {
        jsonString = mycontext?.assets?.open(fileName)?.bufferedReader().use { it?.readText() ?: "test" }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun parsePokedex(): List<Pokemon>{
    val jsonFileString = getJsonDataFromAsset("pokemon.json")
    if (jsonFileString != null) {
        Log.i("data", jsonFileString)
    }
    val gson = Gson()
    val listPokemonType = object : TypeToken<List<Pokemon>>() {}.type
    var pokemon: List<Pokemon> = gson.fromJson(jsonFileString, listPokemonType)
  //  pokemon.forEachIndexed { idx, pokemon -> Log.i("data", "> Item $idx:\n$pokemon")}
    return pokemon
}