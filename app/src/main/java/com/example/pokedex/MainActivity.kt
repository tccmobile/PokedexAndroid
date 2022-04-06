package com.example.pokedex

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.MainActivity.Companion.myPokemon
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {

    companion object {
        public var myContext: Context? = null
        public lateinit var myPokemon: List<Pokemon>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myContext = applicationContext
        myPokemon = parsePokedex()
        setContent {


            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pokedex(navController: NavHostController) {
   // var myPokemon = parsePokedex()


    LazyVerticalGrid(cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(myPokemon.size){ index ->
                pokecard(navController, myPokemon[index])
            }
        })
}

/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        Pokedex(navController)
    }
} */