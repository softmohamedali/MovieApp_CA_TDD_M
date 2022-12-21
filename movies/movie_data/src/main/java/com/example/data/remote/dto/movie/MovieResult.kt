package com.example.data.remote.dto.movie


import com.example.data.remote.dto.movie.RemoteOneMovie
import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val remoteOneMovies: List<RemoteOneMovie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)