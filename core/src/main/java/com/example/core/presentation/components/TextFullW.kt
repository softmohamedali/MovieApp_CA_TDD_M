package com.example.core.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFullW(
    text:String,
    modifier: Modifier=Modifier
        .fillMaxWidth()
        .padding(all = 5.dp),
    fontSize: TextUnit = 12.sp,
){

    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier
    )
}











