package com.example.domin.usecases

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class GetPopulateActorUseCase (
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepositry.getPopulateActor(query)
        emit(result)
    }

}