package com.example.domin.usecases.persisitence

import com.example.domin.models.Actor
import com.example.domin.repo.MoviesRepositry
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
@ViewModelScoped
class IsFavActorUseCase @Inject constructor(
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
        actor:Actor
    ) = flow<Boolean>{
        moviesRepository.getFavActor().collect{ it ->
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