package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class GetFavActorUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke() = flow {
        moviesRepository.getFavActor().collect{
            if (it.isNotEmpty()){
                emit(ResultState.IsSucsses(it))
            }else{
                emit(ResultState.IsError("No Favorites Actor Found"))
            }
        }

    }

}