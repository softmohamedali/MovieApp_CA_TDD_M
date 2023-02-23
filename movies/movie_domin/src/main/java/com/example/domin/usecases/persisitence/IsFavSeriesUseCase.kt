package com.example.domin.usecases.persisitence

import com.example.domin.models.Series
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class IsFavSeriesUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        series: Series
    )= flow<Boolean>{
        moviesRepository.getFavSeries().collect{
            var isfavSeries=false
            it.forEach {
                if (it.hashCode()==series.hashCode()){
                    isfavSeries=true
                }
            }
            emit(isfavSeries)
        }
    }

}