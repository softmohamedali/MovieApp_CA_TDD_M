package com.example.domin.usecases

data class MoviesUseCases(
     val getActorUseCase: GetActorUseCase,
     val getMovieUseCase: GetMovieUseCase,
     val getSeriesUseCase: GetSeriesUseCase,
     val getPopulateMovieUseCase: GetPopulateMovieUseCase,
     val getPopulateActorUseCase: GetPopulateActorUseCase,
     val getPopulateSeriesUseCase: GetPopulateSeriesUseCase,
     val searchMovieUseCase: SearchMovieUseCase
) {
}