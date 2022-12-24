package com.example.presentation.movies

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.presentation.Center

@Composable
fun MovieScreen(
    navHostController: NavHostController
){
    Center {
        Text(text = "movie")
    }
}