package com.example.pokedex

import com.example.pokedex.MainActivity.Companion.myContext
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun getJsonDataFromAsset(fileName: String):String? {
    val jsonString: String
    try{
        jsonString = myContext?.assets?.open(fileName)?.bufferedReader().use {
            it?.readText()?:"test"
        }
    } catch(ioException:IOException){
        ioException.printStackTrace()
        return null
    }

    return jsonString
}


fun parsePokedex():List<Pokemon>{
    val jsonFileString = getJsonDataFromAsset("pokemon.json")
    val gson = Gson()
    val listPokemonType = object : TypeToken<List<Pokemon>>(){}.type
    var pokemon: List<Pokemon> = gson.fromJson(jsonFileString,listPokemonType)
    return pokemon
}