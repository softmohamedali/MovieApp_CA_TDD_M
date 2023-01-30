package com.example.presentation.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.ui.CimaTextStyle
import com.example.core.ui.Title200
import com.example.core.ui.White


@Composable
fun OneDetailsProperty(
    name:String,
    value:String
){
    Row (
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "$name : ",
            style = CimaTextStyle.normalText,
            color =Title200
        )
        Text(
            text = value,
            style = CimaTextStyle.normalText,
            color = White
        )
    }
}