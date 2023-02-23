package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.Movie
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class InsertFavMovieUseCase (
    private  val moviesRepositry: MoviesRepositry
) {

    suspend operator fun invoke(
       movie: Movie
    ) = moviesRepositry.insertFavMovie(movie)

}