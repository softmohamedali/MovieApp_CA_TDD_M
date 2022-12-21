package com.example.data.remote

import com.example.data.remote.dto.actors.RemoteActor
import com.example.data.remote.dto.actors.ActorResult
import com.example.data.remote.dto.movie.MovieResult
import com.example.data.remote.dto.movie.RemoteMovie
import com.example.data.remote.dto.series.RemoteSeries
import com.example.data.remote.dto.series.SeriesResult
import com.example.data.remote.dto.vedio.VedioResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RemoteMovieApi {
    @GET("discover/movie")
    suspend fun getPupulateMovie(@QueryMap query:HashMap<String,String>): Response<MovieResult>

    @GET("discover/tv")
    suspend fun getPopulateSeries(@QueryMap query:HashMap<String,String>):Response<SeriesResult>

    @GET("person/popular")
    suspend fun getPopulatePeople(@QueryMap query:HashMap<String,String>):Response<ActorResult>

    @GET("movie/{movieid}")
    suspend fun getMovie(
        @Path("movieid") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<RemoteMovie>

    @GET("/tv/{tv_id}")
    suspend fun getTv(
        @Path("tv_id") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<RemoteSeries>

    @GET("/person/{person_id}")
    suspend fun getPeople(
        @Path("person_id") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<RemoteActor>

    @GET("/movie/{idm}/videos")
    suspend fun getVedio(
        @Path("idm") id:Int,
        @QueryMap query:HashMap<String,String>
    ):Response<VedioResult>

    @GET("search/movie")
    suspend fun getSearchMovie(@QueryMap query:HashMap<String,String>):Response<MovieResult>


}