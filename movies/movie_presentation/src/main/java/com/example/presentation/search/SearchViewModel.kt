package com.example.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.RemoteMoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private  val movieUseCase:RemoteMoviesUseCases
):ViewModel() {

    var state by mutableStateOf(SearchScreenState())

    init {

    }

    fun onEvent(event:SearchScreenEvent){
        when(event){
            is SearchScreenEvent.OnSearchActorCategorySelect ->{
                state = state.copy(searchCategory = CategorySearch.ACTOR)
            }
            is SearchScreenEvent.OnSearchMovieCategorySelect ->{
                state = state.copy(searchCategory = CategorySearch.MOVIE)
            }
            is SearchScreenEvent.OnSearchSeriesCategorySelect ->{
                state = state.copy(searchCategory = CategorySearch.SERIES)
            }
            is SearchScreenEvent.OnSearchClick ->{
                when{
                    state.searchCategory==CategorySearch.SERIES->{
                        searchSeries()
                    }
                    state.searchCategory==CategorySearch.MOVIE->{
                        searchMovie()
                    }
                    state.searchCategory==CategorySearch.ACTOR->{
                        searchActor()
                    }
                }
            }
        }
    }

    private  fun searchMovie(){
        viewModelScope.launch {
            searchMovieRemote().collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            searchMovie = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        state = state.copy(
                            success = false,
                            loading = false,
                            error= it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        state = state.copy(
                            success = false,
                            loading = true,
                            error = null
                        )
                    }
                }
            }
        }
    }

    private  fun searchSeries(){
        viewModelScope.launch {
            searchSeriesRemote().collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            searchSeries = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        state = state.copy(
                            success = false,
                            loading = false,
                            error= it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        state = state.copy(
                            success = false,
                            loading = true,
                            error = null
                        )
                    }
                }
            }
        }
    }


    private  fun searchActor(){
        viewModelScope.launch {
            searchActorRemote().collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            searchActor = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        state = state.copy(
                            success = false,
                            loading = false,
                            error= it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        state = state.copy(
                            success = false,
                            loading = true,
                            error = null
                        )
                    }
                }
            }
        }
    }

    private suspend fun searchMovieRemote()= withContext(Dispatchers.IO){
        movieUseCase.searchMovieUseCase(CinemaQueries.applyPopularActors())
    }

    private suspend fun searchSeriesRemote()= withContext(Dispatchers.IO){
        movieUseCase.searchSeriesUseCase(CinemaQueries.applyPopularActors())
    }

    private suspend fun searchActorRemote()= withContext(Dispatchers.IO){
        movieUseCase.searchActorUseCase(CinemaQueries.applyPopularActors())
    }

}