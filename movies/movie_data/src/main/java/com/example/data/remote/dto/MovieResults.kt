package com.example.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MovieResults(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val oneMovies: List<OneMovie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)