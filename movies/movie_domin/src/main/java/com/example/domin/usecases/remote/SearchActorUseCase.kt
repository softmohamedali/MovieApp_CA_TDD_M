package com.example.domin.usecases.remote

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
@ViewModelScoped
class SearchActorUseCase @Inject constructor(
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