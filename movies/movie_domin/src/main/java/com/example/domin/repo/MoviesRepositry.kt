package com.example.domin.repo

import com.example.core.domain.models.ResultState
import com.example.domin.models.*

interface MoviesRepositry {

    suspend fun getPopulateMovie(query:HashMap<String,String>): ResultState<List<MovieItem>>

    suspend fun getPopulateSeries(query:HashMap<String,String>):ResultState<List<SeriesItem>>

    suspend fun getPopulateActor(query:HashMap<String,String>):ResultState<List<ActorItem>>

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

    suspend fun getVideo(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Video>

    suspend fun getSearchMovie(query:HashMap<String,String>):ResultState<List<MovieItem>>
}