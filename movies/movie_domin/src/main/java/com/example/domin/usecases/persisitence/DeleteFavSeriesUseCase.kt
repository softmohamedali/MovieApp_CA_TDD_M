package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.Series
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class DeleteFavSeriesUseCase (
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
        series:Series
    ) = moviesRepositry.deleteFavSeries(series)

}