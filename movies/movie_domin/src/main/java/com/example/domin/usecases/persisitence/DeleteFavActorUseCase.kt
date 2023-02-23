package com.example.domin.usecases.persisitence

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.domin.models.Actor
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.flow

class DeleteFavActorUseCase (
    private  val moviesRepository: MoviesRepositry
) {

    suspend operator fun invoke(
       actor: Actor
    ) = moviesRepository.deleteFavActor(actor)


}