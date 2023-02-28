package com.example.presentation.search

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.domain.models.Screens
import com.example.presentation.search.component.SearchScreenView

@Composable
fun SearchScreen(
    navHostController: NavController,
    viewModel: SearchViewModel= hiltViewModel()
) {

    val state = viewModel.state

    SearchScreenView(
        onSearchTextChange = {
            viewModel.onEvent(SearchScreenEvent.OnSearchTextChange(it))
        },
        onSearchClick = {
            viewModel.onEvent(SearchScreenEvent.OnSearchClick)
        },
        onMovieCategoryClick = {
            viewModel.onEvent(SearchScreenEvent.OnSearchMovieCategorySelect)
        },
        onSeriesCategoryClick = {
            viewModel.onEvent(SearchScreenEvent.OnSearchSeriesCategorySelect)
        },
        onActorCategoryClick = {
            viewModel.onEvent(SearchScreenEvent.OnSearchActorCategorySelect)
        },
        searchText = state.searchQuery,
        categorySearch =state.searchCategory ,
        listMovie = state.searchMovie,
        listSeries = state.searchSeries,
        listActor = state.searchActor,
        onActorItemClick = {
            navHostController.navigate(Screens.ActorDetails.navToActorDetailsWithId(it))
        },
        onSeriesItemClick ={
            navHostController.navigate(Screens.SeriesDetails.navToSeriesDetailsWithId(it))
        } ,
        onMovieItemClick = {
            navHostController.navigate(Screens.MovieDetails.navToMovieDetailsWithId(it))
        },
        onBackClick = {
            navHostController.popBackStack()
        },
        loading = state.loading,
        error = state.error
    )
}