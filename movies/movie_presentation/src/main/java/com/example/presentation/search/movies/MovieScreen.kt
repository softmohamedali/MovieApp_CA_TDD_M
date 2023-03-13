package com.example.presentation.search.movies

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.core.presentation.Center
import com.example.presentation.home.HomeViewModel
import com.example.presentation.search.movies.component.MovieScreenView

@Composable
fun MovieScreen(
    navHostController: NavHostController,
    homeViewModel: MovieViewModel = hiltViewModel()
) {
    val state = homeViewModel.state
    MovieScreenView(
        onMovieItemClick = {
            navHostController.navigate(Screens.MovieDetails.navToMovieDetailsWithId(it))
        },
        movies = state.movies,
        error = state.error,
        loading = state.loading
    )
}