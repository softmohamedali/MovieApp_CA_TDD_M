package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.Series
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take

class InsertFavSeriesUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
       series: Series
    ) {
        log("i.m in InsertFavSeriesUseCase")
        IsFavSeriesUseCase(moviesRepository).invoke(series).take(1).collect{
            log("is fav series $it")
            if (it){
                moviesRepository.deleteFavSeries(series)
            }else{
                moviesRepository.insertFavSeries(series)
            }
        }

    }

}