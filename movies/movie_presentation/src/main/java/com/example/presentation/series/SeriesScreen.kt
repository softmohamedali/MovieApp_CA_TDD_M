package com.example.presentation.series

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.presentation.series.component.SeriesScreenView

@Composable
fun SeriesScreen(
    navHostController: NavHostController,
    homeViewModel: SeriesViewModel = hiltViewModel()
) {
    val state = homeViewModel.state
    SeriesScreenView(
        onSeriesItemClick = {
            navHostController.navigate(Screens.SeriesDetails.navToSeriesDetailsWithId(it))
        },
        series = state.series,
        error=state.error,
        loading = state.loading
    )
}