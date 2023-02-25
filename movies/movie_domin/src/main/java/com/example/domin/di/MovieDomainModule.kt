package com.example.domin.di

import com.example.domin.repo.MoviesRepositry
import com.example.domin.usecases.*
import com.example.domin.usecases.persisitence.*
import com.example.domin.usecases.remote.*
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
    fun provideMoviesUseCase(moviesRepositry: MoviesRepositry):RemoteMoviesUseCases{
        return RemoteMoviesUseCases(
            getActorUseCase= GetActorUseCase(moviesRepositry),
            getMovieUseCase= GetMovieUseCase(moviesRepositry),
            getSeriesUseCase= GetSeriesUseCase(moviesRepositry),
            getPopularMovieUseCase= GetPopularMovieUseCase(moviesRepositry),
            getPopularActorUseCase= GetPopularActorUseCase(moviesRepositry),
            getPopularSeriesUseCase= GetPopularSeriesUseCase(moviesRepositry),
            searchMovieUseCase= SearchMovieUseCase(moviesRepositry),
            getVideosUseCase= GetVideosUseCase(moviesRepositry)
        )
    }

    @ViewModelScoped
    @Provides
    fun providePersistenceMoviesUseCase(moviesRepositry: MoviesRepositry):PersistenceMovieUseCases{
        return PersistenceMovieUseCases(
            insertFavActorUseCase= InsertFavActorUseCase(moviesRepositry),
            insertFavMovieUseCase= InsertFavMovieUseCase(moviesRepositry),
            insertFavSeriesUseCase= InsertFavSeriesUseCase(moviesRepositry),
            getFavActorUseCase= GetFavActorUseCase(moviesRepositry),
            getFavSeriesUseCase= GetFavSeriesUseCase(moviesRepositry),
            getFavMoviesUseCase= GetFavMoviesUseCase(moviesRepositry),
            isFavMovieUseCase=IsFavMovieUseCase(moviesRepositry),
            isFavSeriesUseCase=IsFavSeriesUseCase(moviesRepositry),
            isFavActorUseCase=IsFavActorUseCase(moviesRepositry),
        )
    }
}



