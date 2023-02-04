package com.example.presentation.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.presentation.BackButton
import com.example.core.ui.Main_Color
import com.example.presentation.details.components.DetailsView
import com.example.presentation.main.component.MainTopAppBar

@Composable
fun DetailsScreen(
    navHostController: NavHostController,
    movie_id: Int,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(
        key1 = true,
    ) {
        detailsViewModel.onEvent(DetailsEvent.SetMovieId(movie_id))
    }
    val state = detailsViewModel.state
    DetailsView(
        loading = state.loading,
        error = state.error,
        movie = state.movie,
        trailerUrl = state.trailerUrl?:"",
        onBackClick = {
            navHostController.popBackStack()
        }
    )

}