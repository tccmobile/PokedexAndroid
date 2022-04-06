package com.example.pokedex

import android.content.res.Resources
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex.MainActivity.Companion.myPokemon

@Composable
fun pokeDetail( navController: NavHostController, pokemonID: Int?) {
    var sceneWidth = Resources.getSystem().displayMetrics.widthPixels
    var sceneHeight = Resources.getSystem().displayMetrics.heightPixels
    var sceneDepth = Resources.getSystem().displayMetrics.density

    var pokemon = myPokemon[pokemonID?.minus(1)!!]
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentSize(Alignment.Center)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(typeColor(pokemon))
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(topStartPercent = 10, topEndPercent = 10)
                    )
                    .background(Color.White)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .fillMaxHeight(.7f)
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(vertical = 25.dp))
                    Text(pokemon.id.toString(), fontSize = 24.sp)
                    Text(pokemon.name, fontSize = 36.sp)
                    TypeBox(pokemon)
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    attribBox(pokemon,modifier = Modifier.padding(20.dp))
                    Text(
                        pokemon.description,
                        Modifier
                            .width(((sceneWidth / sceneDepth) / 1.5).dp)
                            .height(((sceneHeight / sceneDepth) / 6).dp)
                            .verticalScroll(
                                rememberScrollState()
                            )
                    )
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    statsBox(pokemon)

                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(0.dp, -(sceneHeight / (sceneDepth * 5)).dp)
            ) {
                val pid =
                    LocalContext.current.resources
                        .getIdentifier("p"+pokemon.id, "drawable",
                            LocalContext.current.getPackageName())
                Image(
                    painter = painterResource(pid),
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(
                        width = ((sceneWidth / sceneDepth) / 4).dp,
                        height = ((sceneHeight / sceneDepth) / 4).dp
                    )
                )

            }


        }
    }
}

/*@Composable
@Preview(showBackground = true)
fun detailPreview() {
    pokeDetail(mockPokedex[3], navController)
}
*/
@Composable
fun attribBox(pokemon: Pokemon, modifier: Modifier) {
    Row(modifier = Modifier.padding(10.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(pokemon.weight.toString(), fontSize = 24.sp)
                Text(
                    "KG", modifier = Modifier.padding(2.dp),
                    color = Color.LightGray
                )
            }
            Text("Weight", color = Color.LightGray)
        }
        Spacer(modifier = Modifier.width(15.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(pokemon.height.toString(), fontSize = 24.sp)
                Text(
                    "METER", modifier = Modifier.padding(2.dp),
                    color = Color.LightGray
                )
            }
            Text("Height", color = Color.LightGray)
        }
    }
}
/*
@Composable
@Preview(showBackground = true)
fun previewAttrib() {
    attribBox(mockPokedex[0], modifier = Modifier.padding(20.dp))
}
*/
@Composable
fun statsBox(pokemon: Pokemon) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Stats")
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("ATK")
            Spacer(modifier = Modifier.width(15.dp))
            Text(pokemon.attack.toString())
            Spacer(modifier = Modifier.width(2.dp))
            LinearProgressIndicator(progress = (pokemon.attack/100).toFloat())
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("DEF")
            Spacer(modifier = Modifier.width(15.dp))
            Text(pokemon.defense.toString())
            Spacer(modifier = Modifier.width(2.dp))
            LinearProgressIndicator(progress = (pokemon.defense/100).toFloat())
        }
    }
}
/*
@Composable
@Preview(showBackground = true)
fun previewStats() {
    statsBox(mockPokedex[0])
}
*/
