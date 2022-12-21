package com.example.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SeriesResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<OneSeries>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)