package com.example.pokedex

import android.content.Context
import android.content.res.Resources
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
            .clickable {

            },
        elevation = 10.dp,
        backgroundColor = typeColor(pokemon),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        color = Color.Black
                    )
                ) {
                    append(pokemon.name.uppercase())
                }
            })
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TypeBox(pokemon)
                val pid =
                    LocalContext.current.resources
                    .getIdentifier("p"+pokemon.id, "drawable",
                        LocalContext.current.getPackageName())

                Image(
                    painter= painterResource(pid),
                    contentDescription = pokemon.name,
                    modifier = Modifier.padding(5.dp)
                        .size(height = 50.dp, width = 50.dp)
                )
            }
        }
    }
}

@Composable
fun TypeBox(pokemon: Pokemon) {
    Column(
        modifier = Modifier.wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                //.size(width = 70.dp, height = 30.dp)
                .height(30.dp)
                .width(IntrinsicSize.Min)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.LightGray.copy(alpha = .5f))
        ) {
            Text(
                pokemon.type,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp)
            )
        }
    }
}

fun typeColor(pokemon: Pokemon): Color {
    val pokecolor = when (pokemon.type){
        "fire" -> Color.Red
        "poison" -> Color.Green
        "water" -> Color.Blue
        "electric" -> Color.Yellow
        "psychic" -> Color.Magenta
        "ground" -> Color.DarkGray
        "flying" -> Color.Cyan
        "normal" -> Color.Gray
        "fairy" -> Color.Red
        else -> Color.Gray
    }
    return pokecolor
}


@Composable
@Preview(showBackground = true)
fun pokecardPreview() {
    pokecard(mockPokedex[0])
}