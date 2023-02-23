package com.example.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.RemoteMoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteMoviesUseCases: RemoteMoviesUseCases
):ViewModel(){
    var state by mutableStateOf(HomeState())

    init {
        viewModelScope.launch {
            getPopularMovies()
            getPopularSeries()
            getPopularActors()
        }
    }

    fun onEvent(event: HomeEvent){
        when (event){
            is HomeEvent.OnSwipeRefresh->{
                viewModelScope.launch {
                    getPopularMovies()
                    getPopularSeries()
                    getPopularActors()
                }
            }
        }
    }






    private suspend fun getPopularMovies() = viewModelScope
        .launch{
        remoteMoviesUseCases.getPopularMovieUseCase(CinemaQueries.applyPopularMovie()).collect{
            when (it) {
                is ResultState.IsSucsses -> {
                    state = state.copy(
                        successPA = true,
                        loadingPA = false,
                        errorPA = null,
                        popularMovies = it.data!!
                    )
                }
                is ResultState.IsError -> {
                    state = state.copy(
                        successPA = false,
                        loadingPA = false,
                        errorPA = it.message
                    )
                }
                is ResultState.IsLoading -> {
                    state = state.copy(
                        successPA = false,
                        loadingPA = true,
                        errorPA = null
                    )
                }
            }
        }
    }
    private suspend fun getPopularSeries() = viewModelScope.launch {
        remoteMoviesUseCases.getPopularSeriesUseCase(CinemaQueries.applyPopularSeries()).collect{
            when (it) {
                is ResultState.IsSucsses -> {
                    state = state.copy(
                        successPA = true,
                        loadingPA = false,
                        errorPA = null,
                        popularSeries = it.data!!
                    )
                }
                is ResultState.IsError -> {
                    state = state.copy(
                        successPA = false,
                        loadingPA = false,
                        errorPA = it.message
                    )
                }
                is ResultState.IsLoading -> {
                    state = state.copy(
                        successPA = false,
                        loadingPA = true,
                        errorPA = null
                    )
                }
            }
        }
    }
    private suspend fun getPopularActors() = viewModelScope.launch {
        remoteMoviesUseCases.getPopularActorUseCase(CinemaQueries.applyPopularActors()).collect{
            when (it) {
                is ResultState.IsSucsses -> {
                    state = state.copy(
                        successPA = true,
                        loadingPA = false,
                        errorPA = null,
                        popularActor = it.data!!
                    )
                }
                is ResultState.IsError -> {
                    state = state.copy(
                        successPA = false,
                        loadingPA = false,
                        errorPA = it.message
                    )
                }
                is ResultState.IsLoading -> {
                    state = state.copy(
                        successPA = false,
                        loadingPA = true,
                        errorPA = null
                    )
                }
            }
        }
    }

}