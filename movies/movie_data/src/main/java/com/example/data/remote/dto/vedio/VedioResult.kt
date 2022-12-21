package com.example.data.remote.dto.vedio


import com.google.gson.annotations.SerializedName

data class VedioResult(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<RemoteVedio>
)