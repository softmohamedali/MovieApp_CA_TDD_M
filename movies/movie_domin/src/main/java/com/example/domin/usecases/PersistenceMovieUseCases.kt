package com.example.domin.usecases

import com.example.domin.usecases.persisitence.*

data class PersistenceMovieUseCases (
    val deleteFavMovieUseCase: DeleteFavMovieUseCase,
    val deleteFavSeriesUseCase: DeleteFavSeriesUseCase,
    val deleteFavActorUseCase: DeleteFavActorUseCase,
    val insertFavActorUseCase: InsertFavActorUseCase,
    val insertFavMovieUseCase: InsertFavMovieUseCase,
    val insertFavSeriesUseCase: InsertFavSeriesUseCase,
    val getFavActorUseCase: GetFavActorUseCase,
    val getFavSeriesUseCase: GetFavSeriesUseCase,
    val getFavMoviesUseCase: GetFavMoviesUseCase,
    val isFavMovieUseCase:IsFavMovieUseCase,
    val isFavSeriesUseCase:IsFavSeriesUseCase,
    val isFavActorUseCase:IsFavActorUseCase,
)
