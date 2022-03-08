package com.example.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun pokeDetail(){
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
            ){

            }
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(0.dp, -150.dp)
            ){
                Image(painter = painterResource(id = R.drawable.bulb),
                contentDescription = "Bulbasaur",
                    modifier = Modifier.scale(1.3f) )
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
fun attribBox(){
    Row(){

    }
}

@Composable
@Preview(showBackground = true)
fun previewAttrib(){
    attribBox()
}