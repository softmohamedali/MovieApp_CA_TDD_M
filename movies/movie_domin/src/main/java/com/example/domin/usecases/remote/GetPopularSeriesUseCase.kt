package com.example.domin.usecases.remote

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class GetPopularSeriesUseCase(
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepositry.getPopularSeries(query)
        emit(result)
    }

}