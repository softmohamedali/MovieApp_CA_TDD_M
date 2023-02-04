package com.example.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.MoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val movieUseCase: MoviesUseCases
) : ViewModel() {

    var state by mutableStateOf(DetailsState())

    init {


    }

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.SetMovieId -> {
                state = state.copy(movieId = event.id)
                getMovieVideoUrl()
                getMovieDetails()
            }
        }
    }

    private suspend fun getMovieVideo() = withContext(Dispatchers.IO) {
        movieUseCase.getVideosUseCase(CinemaQueries.applyApiKey(), state.movieId)
    }
    private fun getMovieVideoUrl() {
        viewModelScope.launch {
            getMovieVideo().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        log(it.data.toString())
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            trailerUrl = it.data?.get(0)?.key
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
    private suspend fun getMovie() = withContext(Dispatchers.IO) {
        movieUseCase.getMovieUseCase(CinemaQueries.applyApiKey(), state.movieId)
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            getMovie().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            movie = it.data!!
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
}