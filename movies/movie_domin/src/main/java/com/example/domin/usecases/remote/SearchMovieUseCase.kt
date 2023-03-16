package com.example.domin.usecases.remote

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
@ViewModelScoped
class SearchMovieUseCase @Inject constructor(
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        query:HashMap<String,String>,
    ) = flow {
        emit(ResultState.IsLoading)
        val result=moviesRepositry.getSearchMovie(query)
        emit(result)
    }

}