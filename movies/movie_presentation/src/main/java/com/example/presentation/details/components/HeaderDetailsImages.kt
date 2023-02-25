package com.example.presentation.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.R

@Composable
fun HeaderDetailsImages (
    posterPath:Painter,
    backPosterPath:Painter,
    onFavClick:()->Unit,
    favIconColor:Color
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Center
        ) {
            Image(
                modifier = Modifier.weight(8f).fillMaxWidth(),
                painter = backPosterPath,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.weight(2f))
        }
        
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(180.dp)
                    .width(140.dp),
                painter = posterPath,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {
                    onFavClick()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favorite",
                    modifier = Modifier.size(40.dp),
                    tint = favIconColor
                )
            }
        }

        

        
    }
}