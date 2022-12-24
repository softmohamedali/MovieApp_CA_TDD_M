package com.example.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.core.ui.BG_trans_light
import com.example.core.ui.White

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CinemaCard(
    image:String="",
    rate:String="1.6",
    name:String=" aminzing name your aere naeverr beem watched",
    height:Dp=190.dp,
    width:Dp=140.dp
){
    val painter = rememberImagePainter(
        data =  "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80"
    )

    Column(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(
            RoundedCornerShape(size = 15.dp))
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(8.5f),
            contentAlignment = Alignment.TopEnd
        ){
            Image(
                painter = rememberImagePainter(
                    data =  "https://avatars.githubusercontent.com/u/53933333?v=4"
                ),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .background(BG_trans_light),
            ){
                Text(
                    text = rate,
                    style = TextStyle(
                        color = White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = TextStyle(
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}