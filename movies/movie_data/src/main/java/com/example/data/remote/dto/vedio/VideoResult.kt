package com.example.data.remote.dto.vedio


import com.google.gson.annotations.SerializedName

data class VideoResult(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<RemoteVideo>
)