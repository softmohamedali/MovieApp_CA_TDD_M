package com.example.presentation.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.presentation.Center
import com.example.presentation.component.CinemaCard

@Composable
fun HomeScreen (
    navHostController: NavHostController
){
    Center {
        CinemaCard()
    }
}