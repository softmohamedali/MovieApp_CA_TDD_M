package com.example.data.remote.dto.series


import com.google.gson.annotations.SerializedName

data class SeriesResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<RemoteOneSeries>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)