package com.example.pokedex

import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun pokeDetail(){
    var sceneWidth = Resources.getSystem().displayMetrics.widthPixels
    var sceneHeight = Resources.getSystem().displayMetrics.heightPixels
    var sceneDepth = Resources.getSystem().displayMetrics.density

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentSize(Alignment.Center))
    {
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Green)
        ){
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
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.padding(vertical = 25.dp))
                    Text("#1", fontSize = 24.sp)
                    Text("Bulbasaur", fontSize = 36.sp)
                    TypeBox()
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    attribBox(modifier = Modifier.padding(20.dp))
                    Text("Bulbasaur is a small, quadrupedal Pokémon that has blue-green skin with darker patches. " +
                            "It has red eyes with white pupils, pointed, ear-like structures on top of its head, and a short, blunt snout with a wide mouth. " +
                            "A pair of small, pointed teeth are visible in the upper jaw when its mouth is open. Each of its thick legs ends with three sharp claws. " +
                            "On Bulbasaur's back is a green plant bulb, which is grown from a seed planted there at birth. " +
                            "The bulb also conceals two slender, tentacle-like vines and provides it with energy through photosynthesis as well as from the nutrient-rich seeds contained within.",
                        Modifier
                            .width(((sceneWidth / sceneDepth)/1.5).dp)
                            .height(((sceneHeight / sceneDepth) / 6).dp)
                            .verticalScroll(
                                rememberScrollState()
                            ))
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    statsBox()

            }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(0.dp, -(sceneHeight / (sceneDepth * 5)).dp)
            ){

                Image(painter = painterResource(id = R.drawable.bulb),
                contentDescription = "Bulbasaur",
                    modifier = Modifier.size(width = ((sceneWidth/sceneDepth)/4).dp,
                        height = ((sceneHeight/sceneDepth)/4).dp ) )

            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun detailPreview(){
    pokeDetail()
}

@Composable
fun attribBox(modifier: Modifier){
    Row(modifier = Modifier.padding(10.dp)){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text("0.7", fontSize = 24.sp)
                Text("KG", modifier = Modifier.padding(2.dp),
                color = Color.LightGray)
            }
            Text("Weight", color = Color.LightGray)
        }
        Spacer(modifier = Modifier.width(15.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text("6.9", fontSize = 24.sp)
                Text("METER", modifier = Modifier.padding(2.dp),
                    color = Color.LightGray)
            }
            Text("Height", color = Color.LightGray)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewAttrib(){
    attribBox(modifier = Modifier.padding(20.dp))
}

@Composable
fun statsBox(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Stats")
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("ATK")
            Spacer(modifier = Modifier.width(15.dp))
            Text("49")
            Spacer(modifier = Modifier.width(2.dp))
            LinearProgressIndicator(progress = 0.49f)
        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("DEF")
            Spacer(modifier = Modifier.width(15.dp))
            Text("49")
            Spacer(modifier = Modifier.width(2.dp))
            LinearProgressIndicator(progress = 0.49f)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewStats(){
    statsBox()
}