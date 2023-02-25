package com.example.domin.usecases.remote

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class SearchActorUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>,
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepository.getSearchActor(query)
        emit(result)
    }

}