package com.example.presentation.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.presentation.Center
import com.example.presentation.component.CinemaCard
import com.example.presentation.component.SearchText
import com.example.presentation.home.component.HomeView

@Composable
fun HomeScreen (
    navHostController: NavHostController
){
    HomeView()
}