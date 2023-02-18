package com.example.presentation.favorite

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.presentation.Center


@Composable
fun FavoritesScreen (
    navHostController: NavHostController,
    favoriteViewModel: FavoriteViewModel= hiltViewModel()
){
    Center {
        Text(text = "fav")
    }
}