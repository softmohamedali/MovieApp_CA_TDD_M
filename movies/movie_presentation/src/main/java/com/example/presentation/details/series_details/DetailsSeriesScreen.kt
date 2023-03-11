package com.example.presentation.details.series_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.details.DetailsEvent
import com.example.presentation.details.DetailsViewModel
import com.example.presentation.details.components.DetailsSeriesView


@Composable
fun DetailsSeriesScreen(
    navHostController: NavHostController,
    series_id: Int,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(
        key1 = true,
    ) {
        detailsViewModel.onEvent(DetailsEvent.StartScreenSetSeriesId(series_id))
    }
    val state = detailsViewModel.stateSeries

    DetailsSeriesView(
        loading = state.loading,
        error = state.error,
        series = state.series,
        trailerUrl = state.trailerUrl?:"",
        onBackClick = {
            navHostController.popBackStack()
        },
        onFavClick = {
            detailsViewModel.onEvent(DetailsEvent.InsetSeriesFav)
        },
        isFav = state.isFav
    )



}