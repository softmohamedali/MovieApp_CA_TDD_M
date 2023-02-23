package com.example.presentation.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.RemoteMoviesUseCases
import com.example.presentation.home.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCases: RemoteMoviesUseCases
):ViewModel(){

    var state by mutableStateOf(MovieState())

    init {
        viewModelScope.launch {
            getMovies()

        }
    }

    fun onEvent(event: HomeEvent){
        when (event){
            is HomeEvent.OnSwipeRefresh->{
                viewModelScope.launch {
                    getMovies()

                }
            }
        }
    }






    private suspend fun getMovies() = viewModelScope
        .launch{
            useCases.getPopularMovieUseCase(CinemaQueries.applyPopularMovie()).collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            movies = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        state = state.copy(
                            success = false,
                            loading = false,
                            error = it.message
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