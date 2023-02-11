package com.example.data.repo

import com.example.core.data.connectivity.NetworkConnectivityObserver
import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.log
import com.example.core.domain.utils.safeCall
import com.example.data.mapper.*
import com.example.data.remote.RemoteConstants
import com.example.data.remote.RemoteMovieApi
import com.example.domin.models.*
import com.example.domin.repo.MoviesRepositry
import javax.inject.Inject

class MoviesRepositryImp @Inject constructor(
    private val remoteMovieApi: RemoteMovieApi,
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
                val series=response.body()?.toMovie()
                ResultState.IsSucsses(series)
            }else{
                ResultState.IsError(response.message())
            }
        }

    override suspend fun getSeries(
        id: Int,
        query: HashMap<String, String>
    ): ResultState<Series> =
        safeCall{
            val response=remoteMovieApi.getSeries(id, query)
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
            if (response.isSuccessful){
                val series=response.body()?.toActor()
                ResultState.IsSucsses(series)
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

}
