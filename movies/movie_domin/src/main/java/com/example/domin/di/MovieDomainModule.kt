package com.example.domin.di

import com.example.domin.repo.MoviesRepositry
import com.example.domin.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object MovieDomainModule {



    @ViewModelScoped
    @Provides
    fun provideMoviesUseCase(moviesRepositry: MoviesRepositry):MoviesUseCases{
        return MoviesUseCases(
            getActorUseCase= GetActorUseCase(moviesRepositry),
            getMovieUseCase= GetMovieUseCase(moviesRepositry),
            getSeriesUseCase= GetSeriesUseCase(moviesRepositry),
            getPopularMovieUseCase= GetPopularMovieUseCase(moviesRepositry),
            getPopularActorUseCase= GetPopularActorUseCase(moviesRepositry),
            getPopularSeriesUseCase= GetPopularSeriesUseCase(moviesRepositry),
            searchMovieUseCase= SearchMovieUseCase(moviesRepositry)
        )
    }
}