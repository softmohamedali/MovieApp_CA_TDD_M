package com.example.domin.usecases

data class MoviesUseCases(
     val getActorUseCase: GetActorUseCase,
     val getMovieUseCase: GetMovieUseCase,
     val getSeriesUseCase: GetSeriesUseCase,
     val getPopularMovieUseCase: GetPopularMovieUseCase,
     val getPopularActorUseCase: GetPopularActorUseCase,
     val getPopularSeriesUseCase: GetPopularSeriesUseCase,
     val searchMovieUseCase: SearchMovieUseCase
) {
}