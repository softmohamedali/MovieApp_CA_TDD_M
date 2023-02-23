package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class GetFavSeriesUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke()= flow {
        moviesRepository.getFavSeries().collect{
            if (it.isNotEmpty()){
                emit(ResultState.IsSucsses(it))
            }else{
                emit(ResultState.IsError("No Favorites Series Found"))
            }
        }

    }

}