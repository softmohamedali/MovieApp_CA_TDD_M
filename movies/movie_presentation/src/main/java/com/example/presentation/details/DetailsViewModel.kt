package com.example.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.qulifier.IODispatchers
import com.example.core.domain.qulifier.MainDispatchers
import com.example.core.domain.utils.log
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.PersistenceMovieUseCases
import com.example.domin.usecases.RemoteMoviesUseCases
import com.example.presentation.details.actors_details.DetailsActorState
import com.example.presentation.details.movie_detals.DetailsMovieState
import com.example.presentation.details.series_details.DetailsSeriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val movieUseCase: RemoteMoviesUseCases,
    private val persistenceMovieUseCases: PersistenceMovieUseCases,
    @IODispatchers
    private val ioDispatcher: CoroutineDispatcher,
    @MainDispatchers
    private val mainDispatcher: CoroutineDispatcher,
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
            is DetailsEvent.InsetMovieFav -> {
                insertFavMovie()
            }
            is DetailsEvent.InsetSeriesFav -> {
                insertFavSeries()
            }
            is DetailsEvent.InsetActorFav -> {
                insertFavActor()
            }
        }
    }

    private suspend fun getVideo(id: Int) = withContext(ioDispatcher) {
        movieUseCase.getVideosUseCase(CinemaQueries.applyApiKey(), id)
    }

    private fun getVideoUrl(id: Int) {
        viewModelScope.launch (mainDispatcher){
            getVideo(id).collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        log(it.data.toString())
                        stateMovie = stateMovie.copy(
                            success = true,
                            loading = false,
                            error = null,
                            trailerUrl = if (it.data?.isNotEmpty()!!) {
                                it.data?.get(0)?.key
                            } else {
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

    private suspend fun getMovie() = withContext(ioDispatcher) {
        movieUseCase.getMovieUseCase(CinemaQueries.applyApiKey(), stateMovie.movieId)
    }

    private fun getMovieDetails() {
        viewModelScope.launch (mainDispatcher){
            getMovie().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        stateMovie = stateMovie.copy(
                            success = true,
                            loading = false,
                            error = null,
                            movie = it.data!!
                        )
                        isFavMovie()
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

    private suspend fun getSeries() = withContext(ioDispatcher) {
        movieUseCase.getSeriesUseCase(CinemaQueries.applyApiKey(), stateSeries.seriesId)
    }

    private fun getSeriesDetails() {
        viewModelScope.launch(mainDispatcher) {
            getSeries().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        stateSeries = stateSeries.copy(
                            success = true,
                            loading = false,
                            error = null,
                            series = it.data!!
                        )
                        isFavSeries()
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


    private suspend fun getActor() = withContext(ioDispatcher) {
        movieUseCase.getActorUseCase(CinemaQueries.applyApiKey(), stateActor.actorId)
    }

    private fun getActorDetails() {
        viewModelScope.launch (mainDispatcher){
            getActor().collect {
                when (it) {
                    is ResultState.IsSucsses -> {
                        stateActor = stateActor.copy(
                            success = true,
                            loading = false,
                            error = null,
                            actor = it.data!!
                        )
                        isFavActor()
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

    //-------------------------local
    private fun insertFavMovie() {
        viewModelScope.launch(ioDispatcher) {
            persistenceMovieUseCases.insertFavMovieUseCase(stateMovie.movie)
        }
    }

    private fun insertFavActor() {
        viewModelScope.launch(ioDispatcher) {
            persistenceMovieUseCases.insertFavActorUseCase(stateActor.actor!!)
        }
    }

    private fun insertFavSeries() {
        viewModelScope.launch(ioDispatcher) {
            persistenceMovieUseCases.insertFavSeriesUseCase(stateSeries.series!!)
        }
    }





    private fun isFavMovie() {
        viewModelScope.launch(mainDispatcher) {
            isFavMovieLocal().collect {
                stateMovie = stateMovie.copy(isFav = it)
            }
        }
    }

    private suspend fun isFavMovieLocal()= withContext(ioDispatcher){
        persistenceMovieUseCases.isFavMovieUseCase(stateMovie.movie)
    }

    private fun isFavActor() {
        viewModelScope.launch(mainDispatcher) {
            isFavActorLocal().collect {
                stateActor = stateActor.copy(isFav = it)
            }
        }
    }

    private suspend fun isFavActorLocal()= withContext(ioDispatcher){
        persistenceMovieUseCases.isFavActorUseCase(stateActor.actor!!)
    }

    private fun isFavSeries() {
        viewModelScope.launch(mainDispatcher) {
            isFavSeriesLocal().collect {
                stateSeries = stateSeries.copy(isFav = it)
            }
        }
    }

    private suspend fun isFavSeriesLocal()= withContext(ioDispatcher){
        persistenceMovieUseCases.isFavSeriesUseCase(stateSeries.series!!)
    }

}