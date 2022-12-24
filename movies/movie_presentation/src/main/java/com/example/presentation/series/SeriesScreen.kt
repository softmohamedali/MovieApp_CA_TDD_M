package com.example.presentation.series

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.presentation.Center

@Composable
fun SeriesScreen(
    navHostController: NavHostController
){
    Center {
        Text(text = "series")
    }
}