package com.example.presentation.actors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.MoviesUseCases
import com.example.presentation.home.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ActorViewModel @Inject constructor(
    private val useCases: MoviesUseCases
):ViewModel(){

    var state by mutableStateOf(ActorState())

    init {
        viewModelScope.launch {
            getActor()

        }
    }

    fun onEvent(event: HomeEvent){
        when (event){
            is HomeEvent.OnSwipeRefresh->{
                viewModelScope.launch {
                    getActor()

                }
            }
        }
    }






    private suspend fun getActor() = viewModelScope
        .launch{
            useCases.getPopularActorUseCase(CinemaQueries.applyPopularMovie()).collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            actors = it.data!!
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