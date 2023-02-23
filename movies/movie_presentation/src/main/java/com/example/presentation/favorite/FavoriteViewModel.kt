package com.example.presentation.favorite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.domin.usecases.PersistenceMovieUseCases
import com.example.domin.usecases.RemoteMoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val persistenceMovieUseCases: PersistenceMovieUseCases
):ViewModel() {

    var state by mutableStateOf(FavoriteState())
    init {
        getFavMovies()
        getFavActors()
        getFavSeries()
    }

    private fun getFavMovies(){
        viewModelScope.launch {
            getFavMoviesPersistence().collect{
                when(it){
                    is ResultState.IsError ->{
                        state=state.copy(
                            errorFavMovie = it.message,
                            listFavMovies = listOf()
                        )
                    }
                    is ResultState.IsSucsses ->{
                        state=state.copy(
                            errorFavMovie = null,
                            listFavMovies = it.data!!
                        )
                    }
                }
            }
        }
    }

    private fun getFavSeries(){
        viewModelScope.launch {
            getFavSeriesPersistence().collect{
                when(it){
                    is ResultState.IsError ->{
                        state=state.copy(
                            errorFavSeries = it.message,
                            listFavSeries = listOf()
                        )
                    }
                    is ResultState.IsSucsses ->{
                        state=state.copy(
                            errorFavSeries = null,
                            listFavSeries = it.data!!
                        )
                    }
                }
            }
        }
    }

    private fun getFavActors(){
        viewModelScope.launch {
            getFavActorsPersistence().collect{
                when(it){
                    is ResultState.IsError ->{
                        state=state.copy(
                            errorFavActor = it.message,
                            listFavActors = listOf()
                        )
                    }
                    is ResultState.IsSucsses ->{
                        state=state.copy(
                            errorFavActor = null,
                            listFavActors = it.data!!
                        )
                    }
                }
            }
        }
    }


    private suspend fun getFavMoviesPersistence()= withContext(Dispatchers.IO){
        persistenceMovieUseCases.getFavMoviesUseCase()
    }

    private suspend fun getFavSeriesPersistence()= withContext(Dispatchers.IO){
        persistenceMovieUseCases.getFavSeriesUseCase()
    }

    private suspend fun getFavActorsPersistence()= withContext(Dispatchers.IO){
        persistenceMovieUseCases.getFavActorUseCase()
    }
}