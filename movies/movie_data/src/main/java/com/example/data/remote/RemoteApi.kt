package com.example.data.remote

import com.example.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RemoteApi {
    @GET("discover/movie")
    suspend fun getPupulateMovie(@QueryMap query:HashMap<String,String>): Response<MovieResults>

    @GET("discover/tv")
    suspend fun getPopulateSeries(@QueryMap query:HashMap<String,String>):Response<SeriesResult>

    @GET("person/popular")
    suspend fun getPopulatePeople(@QueryMap query:HashMap<String,String>):Response<PeopleResult>

    @GET("movie/{movieid}")
    suspend fun getMovie(
        @Path("movieid") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<Movie>

    @GET("/tv/{tv_id}")
    suspend fun getTv(
        @Path("tv_id") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<Tv>

    @GET("/person/{person_id}")
    suspend fun getPeople(
        @Path("person_id") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<Actor>

    @GET("/movie/{idm}/videos")
    suspend fun getVedio(
        @Path("idm") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<Vedio>

    @GET("search/movie")
    suspend fun getSearchMovie(@QueryMap query:HashMap<String,String>):Response<MovieResults>


}