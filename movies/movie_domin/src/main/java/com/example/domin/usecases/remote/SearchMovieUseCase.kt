package com.example.domin.usecases.remote

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class SearchMovieUseCase(
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>,
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepositry.getSearchMovie(query)
        log("SearchMovieUseCase $result")
        emit(result)
    }

}