package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take

class GetFavSeriesUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke()= flow {
        log("i.m in GetFavSeriesUseCase")

        moviesRepository.getFavSeries().collect{
            log("is fav series $it")
            if (it.isNotEmpty()){
                emit(ResultState.IsSucsses(it))
            }else{
                emit(ResultState.IsError("No Favorites Series Found"))
            }
        }

    }

}