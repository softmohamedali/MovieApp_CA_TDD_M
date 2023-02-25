package com.example.domin.usecases.persisitence

import com.example.domin.models.Actor
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class IsFavActorUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        actor:Actor
    ) = flow<Boolean>{
        moviesRepository.getFavMovies().collect{ it ->
            var isFavActor=false
            it.forEach {
                if (it.id==actor.id){
                    isFavActor=true
                }
            }
            emit(isFavActor)
        }
    }

}