package com.example.presentation.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun HeaderDetailsImages (
    posterPath:Painter,
    backPosterPath:Painter
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                modifier = Modifier.weight(8f),
                painter = backPosterPath,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.weight(2f))
        }

        Image(
            modifier = Modifier
                .padding(start = 10.dp)
                .height(180.dp)
                .width(140.dp),
            painter = posterPath,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}