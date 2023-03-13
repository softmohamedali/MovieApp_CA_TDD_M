package com.example.presentation.favorite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.qulifier.IODispatchers
import com.example.core.domain.qulifier.MainDispatchers
import com.example.domin.usecases.PersistenceMovieUseCases
import com.example.domin.usecases.RemoteMoviesUseCases
import com.example.domin.usecases.persisitence.GetFavActorUseCase
import com.example.domin.usecases.persisitence.GetFavMoviesUseCase
import com.example.domin.usecases.persisitence.GetFavSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavMoviesUseCase: GetFavMoviesUseCase,
    private val getFavActorUseCase: GetFavActorUseCase,
    private val getFavSeriesUseCase: GetFavSeriesUseCase,
    @IODispatchers
    private val ioDispatcher: CoroutineDispatcher,
    @MainDispatchers
    private val mainDispatcher: CoroutineDispatcher,
):ViewModel() {

    var state by mutableStateOf(FavoriteState())
    init {
        getFavMovies()
        getFavActors()
        getFavSeries()
    }

    private fun getFavMovies(){
        viewModelScope.launch(mainDispatcher) {
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
        viewModelScope.launch(mainDispatcher) {
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
        viewModelScope.launch(mainDispatcher) {
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


    private suspend fun getFavMoviesPersistence()= withContext(ioDispatcher){
        getFavMoviesUseCase()
    }

    private suspend fun getFavSeriesPersistence()= withContext(ioDispatcher){
        getFavSeriesUseCase()
    }

    private suspend fun getFavActorsPersistence()= withContext(ioDispatcher){
        getFavActorUseCase()
    }
}