package com.example.domin.usecases.persisitence

import com.example.domin.models.Movie
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.take
import javax.inject.Inject
@ViewModelScoped
class InsertFavMovieUseCase @Inject constructor(
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