package com.example.domin.usecases

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
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
        log("GetActorUseCase:result is  ${result.data} id:${id}")
        emit(result)
    }

}