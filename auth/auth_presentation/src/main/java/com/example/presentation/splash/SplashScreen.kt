package com.example.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.core.presentation.Center
import com.example.core.ui.BG_trans_light
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (
    navHostController: NavHostController,
    splashViewModel: SplashViewModel= hiltViewModel()
){
    LaunchedEffect(key1 = true, block = {
        delay(2)
        if (splashViewModel.getCurrentUser()==null){
            navHostController.navigate(Screens.Login.route)
        }else{
            navHostController.navigate(Screens.Main.route)
        }
    })

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(BG_trans_light)) {
        Center {
            Text(text = "Splash Screen")
        }
    }
}