package com.example.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyLine(
    paddding:Float=0f,
    height:Float=1f,
    color: Color=Color.Black.copy(0.5f)
){
    Surface(
        modifier = Modifier.fillMaxWidth().height(height = height.dp),
        color = color
    ) {
    }
}