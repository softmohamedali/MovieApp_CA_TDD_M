package com.example.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.core.ui.BG_trans_light
import com.example.core.ui.White
import com.example.domin.utils.MovieDomainConstants.BASE_IMG_URL

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CinemaCard(
    image:String="",
    rate:String="1.6",
    name:String=" aminzing name your aere naeverr beem watched",
    height:Dp=190.dp,
    width:Dp=140.dp,
    showRate:Boolean=true,
    id:Int,
    onCardClick:(Int)->Unit,
    modifier: Modifier=Modifier
){
    val painter = rememberImagePainter(
        data =  BASE_IMG_URL+image,
    )

    Column(
        modifier = modifier
            .width(width)
            .height(height)
            .clip(
            RoundedCornerShape(size = 8.dp))
            .clickable {
                onCardClick(id)
            }
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(8.5f),
            contentAlignment = Alignment.TopEnd
        ){
            Image(
                painter = painter,
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

           if (showRate){
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