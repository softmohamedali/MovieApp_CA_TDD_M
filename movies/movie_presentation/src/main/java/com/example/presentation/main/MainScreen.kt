package com.example.presentation.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.main.component.MainView

@Composable
fun MainScreen (
    navHostController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
){
    MainView(navHostController, mainViewModel)
}