package com.example.domin.usecases.persisitence

import com.example.domin.models.Movie
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
@ViewModelScoped
class IsFavMovieUseCase @Inject constructor(
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