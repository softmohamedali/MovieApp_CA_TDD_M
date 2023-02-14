package com.example.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.presentation.home.component.HomeView

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val state = homeViewModel.state
    HomeView(
        loading = state.loadingPA,
        error = state.errorPA,
        popularMovie = state.popularMovies,
        popularSeries = state.popularSeries,
        popularActors = state.popularActor,
        onSwipeToResfresh = {
            homeViewModel.onEvent(HomeEvent.OnSwipeRefresh)
        },
        onMovieCardClick = { id ->
            navHostController.navigate(Screens.MovieDetails.navToMovieDetailsWithId(id))
        },
        onSeriesCardClick = { id ->
            navHostController.navigate(Screens.SeriesDetails.navToSeriesDetailsWithId(id))
        },
        onActorCardClick = { id ->
            navHostController.navigate(Screens.ActorDetails.navToActorDetailsWithId(id))
        }
    )
}