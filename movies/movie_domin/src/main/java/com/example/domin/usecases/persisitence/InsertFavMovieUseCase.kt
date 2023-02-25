package com.example.domin.usecases.persisitence

import com.example.domin.models.Movie
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.take

class InsertFavMovieUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
       movie: Movie
    ) {
        IsFavMovieUseCase(moviesRepository).invoke(movie).take(1).collect{
            if (it){
                moviesRepository.deleteFavMovie(movie)
            }else{
                moviesRepository.insertFavMovie(movie)
            }
        }

    }

}