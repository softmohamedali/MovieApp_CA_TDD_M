package com.example.domin.repo

import com.example.core.domain.models.ResultState
import com.example.domin.models.*
import kotlinx.coroutines.flow.Flow

interface MoviesRepositry {

    suspend fun getPopularMovie(query:HashMap<String,String>): ResultState<List<MovieItem>>

    suspend fun getPopularSeries(query:HashMap<String,String>):ResultState<List<SeriesItem>>

    suspend fun getPopularActor(query:HashMap<String,String>):ResultState<List<ActorItem>>

    suspend fun getMovie(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Movie>

    suspend fun getSeries(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Series>

    suspend fun getActor(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Actor>

    suspend fun getVideos(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<List<Video>>

    suspend fun getSearchMovie(query:HashMap<String,String>):ResultState<List<MovieItem>>

    suspend fun getSearchSeries(query:HashMap<String,String>):ResultState<List<SeriesItem>>

    suspend fun getSearchActor(query:HashMap<String,String>):ResultState<List<ActorItem>>



    //------------------------------local
    suspend fun insertFavMovie(movie:Movie)

    suspend fun insertFavSeries(series:Series)

    suspend fun insertFavActor(actor:Actor)


    suspend fun deleteFavMovie(movie:Movie)

    suspend fun deleteFavSeries(series:Series)

    suspend fun deleteFavActor(movie:Actor)


    suspend fun getFavMovies(): Flow<List<Movie>>

    suspend fun getFavSeries(): Flow<List<Series>>

    suspend fun getFavActor(): Flow<List<Actor>>
}