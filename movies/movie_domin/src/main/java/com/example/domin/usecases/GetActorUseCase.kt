package com.example.domin.usecases

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class GetActorUseCase(
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>,
        id:Int
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepositry.getActor(id,query)
        emit(result)
    }

}