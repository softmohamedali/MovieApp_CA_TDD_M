package com.example.presentation.main.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainAppBar(
    title:@Composable ()->Unit={
        Text(text = "Cinema House")
    },
    actions: @Composable RowScope.() -> Unit = {},
){
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        title =title,
        actions = {
            actions()
        }
    )
}