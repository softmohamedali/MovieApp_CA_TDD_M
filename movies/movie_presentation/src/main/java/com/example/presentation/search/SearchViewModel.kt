package com.example.presentation.search

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
import com.example.domin.usecases.RemoteMoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private  val movieUseCase:RemoteMoviesUseCases,
    @IODispatchers
    private val ioDispatcher: CoroutineDispatcher,
    @MainDispatchers
    private val mainDispatcher: CoroutineDispatcher,
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
            is SearchScreenEvent.OnSearchTextChange ->{
                state = state.copy(searchQuery = event.text)
            }
        }
    }

    private  fun searchMovie(){
        viewModelScope.launch (mainDispatcher){
            searchMovieRemote().collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            searchMovie = it.data!!
                        )
                        log("searchMovie viewModel ${it.data}")
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
        viewModelScope.launch(mainDispatcher) {
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
        viewModelScope.launch(mainDispatcher) {
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

    private suspend fun searchMovieRemote()= withContext(ioDispatcher){
        movieUseCase.searchMovieUseCase(CinemaQueries.applySearchQueri(state.searchQuery,"1"))
    }

    private suspend fun searchSeriesRemote()= withContext(ioDispatcher){
        movieUseCase.searchSeriesUseCase(CinemaQueries.applySearchQueri(state.searchQuery,"1"))
    }

    private suspend fun searchActorRemote()= withContext(ioDispatcher){
        movieUseCase.searchActorUseCase(CinemaQueries.applySearchQueri(state.searchQuery,"1"))
    }

}