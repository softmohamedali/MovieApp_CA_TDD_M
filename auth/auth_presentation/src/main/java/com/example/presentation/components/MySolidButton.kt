package com.example.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MySolidButton(
    text:String="",
    modifier: Modifier= Modifier.alpha(1f),
    corner:Int=15,
    enable:Boolean=true,
    onclick:()->Unit,
){
    Button(
        modifier = modifier
            .clip(RoundedCornerShape(size = corner.dp)),
        onClick = onclick,
        colors=ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        enabled = enable
    ) {
        Text(text = text)
    }
}
