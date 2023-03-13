package com.example.domin.usecases.persisitence

import com.example.domin.models.Actor
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.take
import javax.inject.Inject
@ViewModelScoped
class InsertFavActorUseCase @Inject constructor(
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        actor:Actor
    ) {
        IsFavActorUseCase(moviesRepository).invoke(actor).take(1).collect{
            if (it){
                moviesRepository.deleteFavActor(actor)
            }else{
                moviesRepository.insertFavActor(actor)
            }
        }

    }

}