package com.example.presentation.actors

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.presentation.Center

@Composable
fun ActorsScreen(
    navHostController: NavHostController
) {
    Center {
        Text(text = "actors")
    }
}