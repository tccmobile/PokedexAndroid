package com.example.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun pokecard(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { },
        elevation = 10.dp,
        backgroundColor = Color.Green,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W900,
                color = Color.Black)){
                    append(pokemon.name)
                }
            })
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                TypeBox(pokemon)
                Image(painter = painterResource(id = R.drawable.bulb),
                    contentDescription = pokemon.name,
                modifier = Modifier.padding(5.dp))
            }
        }
    }
}

@Composable
fun TypeBox(pokemon: Pokemon) {
    Column(
        modifier = Modifier.wrapContentSize(Alignment.Center)
    ) {
       Box(modifier = Modifier.size(width = 70.dp, height = 30.dp)
           .clip(RoundedCornerShape(15.dp))
           .background(Color.LightGray)) {
           Text(pokemon.type,
           modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp))
       }
    }
}


@Composable
@Preview(showBackground = true)
fun pokecardPreview(){
    pokecard(mockPokedex[0])
}