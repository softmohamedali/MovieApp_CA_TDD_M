package com.example.domin.usecases

import com.example.domin.usecases.remote.*

data class RemoteMoviesUseCases(
    val getActorUseCase: GetActorUseCase,
    val getMovieUseCase: GetMovieUseCase,
    val getSeriesUseCase: GetSeriesUseCase,
    val getPopularMovieUseCase: GetPopularMovieUseCase,
    val getPopularActorUseCase: GetPopularActorUseCase,
    val getPopularSeriesUseCase: GetPopularSeriesUseCase,
    val searchMovieUseCase: SearchMovieUseCase,
    val searchSeriesUseCase: SearchSeriesUseCase,
    val searchActorUseCase: SearchActorUseCase,
    val getVideosUseCase: GetVideosUseCase
) {
}