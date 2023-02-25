package com.example.presentation.details.actors_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.details.DetailsEvent
import com.example.presentation.details.DetailsViewModel
import com.example.presentation.details.components.DetailsActorView
import com.example.presentation.details.components.DetailsSeriesView


@Composable
fun DetailsActorScreen(
    navHostController: NavHostController,
    series_id: Int,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(
        key1 = true,
    ) {
        detailsViewModel.onEvent(DetailsEvent.StartScreenSetActorId(series_id))
    }
    val state = detailsViewModel.stateActor

    if (state.actor!=null){
        DetailsActorView(
            loading = state.loading,
            error = state.error,
            actor = state.actor,
            trailerUrl = state.trailerUrl?:"",
            onBackClick = {
                navHostController.popBackStack()
            },
            onFavClick = {
                detailsViewModel.onEvent(DetailsEvent.InsetActorFav)
            },
            isFav = state.isFav
        )
    }


}