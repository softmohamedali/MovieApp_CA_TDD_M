package com.example.presentation.series

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.qulifier.IODispatchers
import com.example.core.domain.qulifier.MainDispatchers
import com.example.domin.models.CinemaQueries
import com.example.domin.usecases.remote.GetPopularSeriesUseCase
import com.example.presentation.home.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getPopularSeriesUseCase: GetPopularSeriesUseCase,
    @IODispatchers
    private val ioDispatcher: CoroutineDispatcher,
    @MainDispatchers
    private val mainDispatcher: CoroutineDispatcher,
):ViewModel(){

    var state by mutableStateOf(SeriesState())

    init {
        viewModelScope.launch {
            getSeries()

        }
    }

    fun onEvent(event: HomeEvent){
        when (event){
            is HomeEvent.OnSwipeRefresh->{
                viewModelScope.launch(mainDispatcher) {
                    getSeries()

                }
            }
        }
    }






    private suspend fun getSeries() = viewModelScope
        .launch(mainDispatcher){
            getPopularSeriesUseCase(CinemaQueries.applyPopularMovie()).collect{
                when (it) {
                    is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            loading = false,
                            error = null,
                            series = it.data!!
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