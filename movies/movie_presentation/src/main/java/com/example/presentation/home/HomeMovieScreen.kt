package com.example.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun HomeMovieScreen (
    navHostController: NavHostController
){
    Box(contentAlignment = Alignment.Center) {
        Text(text ="Home")
    }
}