package com.example.presentation.main.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ui.Bottom_Nav_Color
import com.example.core.ui.Main_Color
import com.example.core.ui.White

@Composable
fun MainTopAppBar(
    title:@Composable ()->Unit={
        Text(
            text = "Cinema House",
            style = TextStyle(
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
    },
    actions: @Composable RowScope.() -> Unit = {},
){
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        title =title,
        backgroundColor = Bottom_Nav_Color,
        actions = {
            actions()
        }
    )
}