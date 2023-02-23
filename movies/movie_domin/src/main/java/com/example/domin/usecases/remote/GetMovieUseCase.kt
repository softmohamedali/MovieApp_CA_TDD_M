package com.example.domin.usecases.remote

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class GetMovieUseCase(
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>,
        id:Int
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepositry.getMovie(id,query)
        emit(result)
    }

}