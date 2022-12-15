package com.example.core.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun MyOutLineButton(
    text:String="",
    width:Float=150f,
    modifier: Modifier=Modifier.width(width.dp),
    textColor:Color=MaterialTheme.colors.primary,
    backgroundColor: Color=MaterialTheme.colors.onBackground,
    onclick:()->Unit,
){
    OutlinedButton(
        modifier =modifier,
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor =backgroundColor
        ),
        border = BorderStroke(1.dp, textColor),
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor
            )
        )
    }
}













