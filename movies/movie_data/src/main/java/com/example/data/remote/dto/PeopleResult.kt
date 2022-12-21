package com.example.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PeopleResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<OneActor>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)