package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.Series
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import javax.inject.Inject
@ViewModelScoped
class InsertFavSeriesUseCase @Inject constructor(
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
       series: Series
    ) {
        IsFavSeriesUseCase(moviesRepository).invoke(series.id).take(1).collect{
            if (it){
                moviesRepository.deleteFavSeries(series)
            }else{
                moviesRepository.insertFavSeries(series)
            }
        }

    }

}