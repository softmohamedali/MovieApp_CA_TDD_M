package com.example.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.RemoteMoviesUseCases
import com.example.presentation.details.actors_details.DetailsActorState
import com.example.presentation.details.movie_detals.DetailsMovieState
import com.example.presentation.details.series_details.DetailsSeriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val movieUseCase: RemoteMoviesUseCases,

) : ViewModel() {

    var stateMovie by mutableStateOf(DetailsMovieState())
    var stateSeries by mutableStateOf(DetailsSeriesState())
    var stateActor by mutableStateOf(DetailsActorState())



    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.StartScreenSetMovieId -> {
                stateMovie = stateMovie.copy(movieId = event.id)
                getVideoUrl(stateMovie.movieId)
                getMovieDetails()
            }
            is DetailsEvent.StartScreenSetSeriesId -> {
                stateSeries = stateSeries.copy(seriesId = event.id)
                getVideoUrl(stateSeries.seriesId)
                getSeriesDetails()
            }
            is DetailsEvent.StartScreenSetActorId -> {
                stateActor = stateActor.copy(actorId = event.id)
                getActorDetails()
            }
        }
    }

    private suspend fun getVideo(id:Int) = withContext(Dispatchers.IO) {
        movieUseCase.getVideosUseCase(CinemaQueries.applyApiKey(), id)
    }
    private fun getVideoUrl(id:Int) {
        viewModelScope.launch {
            getVideo(id).collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        log(it.data.toString())
                        stateMovie = stateMovie.copy(
                            success = true,
                            loading = false,
                            error = null,
                            trailerUrl = if(it.data?.isNotEmpty()!!) {
                                it.data?.get(0)?.key
                            }else{
                                ""
                            }
                        )
                    }
                    is ResultState.IsError -> {
                        stateMovie = stateMovie.copy(
                            success = false,
                            loading = false,
                            error = it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        stateMovie = stateMovie.copy(
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
        movieUseCase.getMovieUseCase(CinemaQueries.applyApiKey(), stateMovie.movieId)
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            getMovie().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        stateMovie = stateMovie.copy(
                            success = true,
                            loading = false,
                            error = null,
                            movie = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        stateMovie = stateMovie.copy(
                            success = false,
                            loading = false,
                            error = it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        stateMovie = stateMovie.copy(
                            success = false,
                            loading = true,
                            error = null
                        )
                    }
                }
            }
        }

    }

    private suspend fun getSeries() = withContext(Dispatchers.IO) {
        movieUseCase.getSeriesUseCase(CinemaQueries.applyApiKey(), stateSeries.seriesId)
    }

    private fun getSeriesDetails() {
        viewModelScope.launch {
            getSeries().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        stateSeries = stateSeries.copy(
                            success = true,
                            loading = false,
                            error = null,
                            series = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        stateSeries = stateSeries.copy(
                            success = false,
                            loading = false,
                            error = it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        stateSeries = stateSeries.copy(
                            success = false,
                            loading = true,
                            error = null
                        )
                    }
                }
            }
        }

    }


    private suspend fun getActor() = withContext(Dispatchers.IO) {
        movieUseCase.getActorUseCase(CinemaQueries.applyApiKey(), stateActor.actorId)
    }

    private fun getActorDetails() {
        viewModelScope.launch {
            getActor().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        stateActor = stateActor.copy(
                            success = true,
                            loading = false,
                            error = null,
                            actor = it.data!!
                        )
                    }
                    is ResultState.IsError -> {
                        stateActor = stateActor.copy(
                            success = false,
                            loading = false,
                            error = it.message
                        )
                    }
                    is ResultState.IsLoading -> {
                        stateActor = stateActor.copy(
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