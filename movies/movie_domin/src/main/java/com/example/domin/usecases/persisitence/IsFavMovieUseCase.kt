package com.example.domin.usecases.persisitence

import com.example.domin.models.Movie
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class IsFavMovieUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        movie: Movie
    )= flow<Boolean>{
        moviesRepository.getFavMovies().collect{
            var isfavMovie=false
            it.forEach {
                if (it.id==movie.id){
                    isfavMovie=true
                }
            }
            emit(isfavMovie)
        }
    }

}