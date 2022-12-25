package com.example.domin.repo

import com.example.core.domain.models.ResultState
import com.example.domin.models.*

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
}