package com.example.presentation.favorite

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.core.presentation.Center
import com.example.presentation.favorite.component.FavoriteView


@Composable
fun FavoritesScreen(
    navHostController: NavHostController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {

    FavoriteView(
        favMovies = favoriteViewModel.state.listFavMovies,
        favSeries = favoriteViewModel.state.listFavSeries,
        favActor = favoriteViewModel.state.listFavActors,
        onFavMovieClick = {
            navHostController.navigate(Screens.MovieDetails.navToMovieDetailsWithId(it))
        },
        onFavSeriesClick = {
            navHostController.navigate(Screens.SeriesDetails.navToSeriesDetailsWithId(it))
        },
        onFavActorClick = {
            navHostController.navigate(Screens.ActorDetails.navToActorDetailsWithId(it))
        }
    )



}


