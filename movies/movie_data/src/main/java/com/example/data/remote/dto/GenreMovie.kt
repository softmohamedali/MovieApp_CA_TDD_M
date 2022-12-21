package com.example.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GenreMovie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)