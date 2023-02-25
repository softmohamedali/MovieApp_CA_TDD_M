package com.example.data.repo

import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.core.domain.utils.safeCall
import com.example.data.local.MovieDao
import com.example.data.mapper.*
import com.example.data.remote.RemoteMovieApi
import com.example.domin.models.*
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesRepositryImp @Inject constructor(
    private val remoteMovieApi: RemoteMovieApi,
    private val movieDao: MovieDao
): MoviesRepositry {

    override suspend fun getPopularMovie(query: HashMap<String, String>): ResultState<List<MovieItem>> =
        safeCall{
            val response=remoteMovieApi.getPopulateMovie(query)
            if (response.isSuccessful){
                val movies=response.body()?.remoteOneMovies?.toListMovieItems()
                ResultState.IsSucsses(movies)
            }else{
                log(response.message())
                ResultState.IsError(response.message())

            }
        }

    override suspend fun getPopularSeries(query: HashMap<String, String>):ResultState<List<SeriesItem>> =
        safeCall{
            val response=remoteMovieApi.getPopulateSeries(query)
            if (response.isSuccessful){
                log("result series ${response.body()?.results}")
                val series= response.body()?.results?.toListSeriesItems()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getPopularActor(query: HashMap<String, String>): ResultState<List<ActorItem>> =
        safeCall{
            val response=remoteMovieApi.getPopulateActors(query)
            if (response.isSuccessful){
                val series=response.body()?.results?.toListActorItems()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }


    override suspend fun getMovie(
        id: Int,
        query: HashMap<String, String>
    ):ResultState<Movie> =
        safeCall{
            val response=remoteMovieApi.getMovie(id, query)
            if (response.isSuccessful){
                val movie=response.body()?.toMovie()
                ResultState.IsSucsses(movie)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getSeries(
        id: Int,
        query: HashMap<String, String>
    ): ResultState<Series> =
        safeCall{
            log("getSeries response ")
            val response=remoteMovieApi.getSeries(id, query)
            log("getSeries response ${response.body()}")
            if (response.isSuccessful){
                val series=response.body()?.toSeries()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getActor(
        id: Int,
        query: HashMap<String, String>
    ): ResultState<Actor> =
        safeCall{
            val response=remoteMovieApi.getActor(id, query)
            log("GetActorUseCase:result is  ${response.body()} id:${id} is ${response.isSuccessful}")
            if (response.isSuccessful){
                val actor=response.body()?.toActor()
                log("GetActorUseCase:result is  ${response.body()} id:${id} actor ${actor}")
                ResultState.IsSucsses(actor)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getVideos(
        id: Int,
        query: HashMap<String, String>
    ): ResultState<List<Video>> =
        safeCall{
            val response=remoteMovieApi.getVideo(id, query)
            log("getvideo response ${response.body()}")
            if (response.isSuccessful){
                val series=response.body()?.results?.toListVideo()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getSearchMovie(query: HashMap<String, String>):ResultState<List<MovieItem>> =
        safeCall{
            val response=remoteMovieApi.getSearchMovie(query)
            if (response.isSuccessful){
                val series=response.body()?.remoteOneMovies?.toListMovieItems()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getSearchSeries(query: HashMap<String, String>): ResultState<List<SeriesItem>> =
        safeCall{
            val response=remoteMovieApi.getSearchSeries(query)
            if (response.isSuccessful){
                val series=response.body()?.results?.toListSeriesItems()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getSearchActor(query: HashMap<String, String>): ResultState<List<ActorItem>> =
        safeCall{
            val response=remoteMovieApi.getSearchActor(query)
            if (response.isSuccessful){
                val series=response.body()?.results?.toListActorItems()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }
    //-------------------------------local
    override suspend fun insertFavMovie(movie: Movie) {
        movieDao.insertFavMovie(movie.toMovieLocal())
    }

    override suspend fun insertFavSeries(series: Series) {
        movieDao.insertFavSeries(series.toSeriesLocal())
    }

    override suspend fun insertFavActor(actor: Actor) {
        movieDao.insertFavActor(actor.toActorLocal())
    }

    override suspend fun deleteFavMovie(movie: Movie) {
        movieDao.deleteFavMovie(movie.toMovieLocal())
    }

    override suspend fun deleteFavSeries(series: Series) {
        movieDao.deleteFavSeries(series.toSeriesLocal())
    }

    override suspend fun deleteFavActor(actor: Actor) {
        movieDao.deleteFavActor(actor.toActorLocal())
    }

    override suspend fun getFavMovies(): Flow<List<Movie>> = flow{
        movieDao.getFavMovies().collect{
            emit(it.toListMovie())
        }
    }

    override suspend fun getFavSeries(): Flow<List<Series>> = flow{
        movieDao.getFavSeries().collect{
            emit(it.toListSeries())
        }
    }

    override suspend fun getFavActor(): Flow<List<Actor>> = flow{
        movieDao.getFavActor().collect{
            emit(it.toListActor())
        }
    }

}
