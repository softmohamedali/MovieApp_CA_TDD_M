package com.example.domin.usecases.persisitence

import com.example.domin.models.Actor
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.take

class InsertFavActorUseCase(
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        actor:Actor
    ) {
        IsFavActorUseCase(moviesRepository).invoke(actor).take(1).collect{
            if (it){
                moviesRepository.deleteFavActor(actor)
            }else{
                moviesRepository.deleteFavActor(actor)
            }
        }

    }

}