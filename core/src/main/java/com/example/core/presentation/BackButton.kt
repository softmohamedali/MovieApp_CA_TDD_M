package com.example.core.presentation

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.core.R
import com.example.core.ui.White

@Composable
fun BackButton(
    onBackClick:()->Unit
) {
    IconButton(
        onClick = {
            onBackClick()
        },
        content = {
            Icon(
                painter = painterResource(id = R.drawable.back_button_en_ic) ,
                contentDescription = "back",
                tint = White
            )
        }
    )
}