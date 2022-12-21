package com.example.data.remote.dto.actors


import com.google.gson.annotations.SerializedName

data class ActorResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<RemoteOneActor>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)