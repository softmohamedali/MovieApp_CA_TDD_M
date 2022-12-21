package com.example.data.remote.dto.movie


import com.google.gson.annotations.SerializedName

data class RemoteGenreMovie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)