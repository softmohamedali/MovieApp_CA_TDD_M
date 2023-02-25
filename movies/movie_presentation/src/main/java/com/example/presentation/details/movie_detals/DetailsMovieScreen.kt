package com.example.presentation.details.movie_detals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.details.DetailsEvent
import com.example.presentation.details.DetailsViewModel
import com.example.presentation.details.components.DetailsMovieView

@Composable
fun MovieDetailsScreen(
    navHostController: NavHostController,
    movie_id: Int,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(
        key1 = true,
    ) {
        detailsViewModel.onEvent(DetailsEvent.StartScreenSetMovieId(movie_id))
    }
    val state = detailsViewModel.stateMovie
    DetailsMovieView(
        loading = state.loading,
        error = state.error,
        movie = state.movie,
        trailerUrl = state.trailerUrl?:"",
        onBackClick = {
            navHostController.popBackStack()
        },
        onFavClick = {
            detailsViewModel.onEvent(DetailsEvent.InsetMovieFav)
        },
        isFav = state.isFav
    )

}