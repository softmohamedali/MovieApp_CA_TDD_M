package com.example.data.remote.dto.series


import com.google.gson.annotations.SerializedName

data class RemoteGenreSeries(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)