package com.example.domin.repo

import com.example.core.domain.models.ResultState

interface MoviesRepositry {

    suspend fun getPopulateMovie(query:HashMap<String,String>): ResultState<MovieResults>

    suspend fun getPopulateSeries(query:HashMap<String,String>):ResultState<SeriesResult>

    suspend fun getPopulatePeople(query:HashMap<String,String>):ResultState<PeopleResult>

    suspend fun getMovie(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Movie>

    suspend fun getTv(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Tv>

    suspend fun getPeople(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Actor>

    suspend fun getVedio(
        id:Int,
        query:HashMap<String,String>
    ):ResultState<Vedio>

    suspend fun getSearchMovie(query:HashMap<String,String>):ResultState<MovieResults>
}