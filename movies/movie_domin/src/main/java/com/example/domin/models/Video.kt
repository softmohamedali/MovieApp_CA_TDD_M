package com.example.domin.models

data class Video(
    val id: String,
    val iso31661: String,
    val iso6391: String,
    val key: String,
    val name: String,
    val site: String,
    val size: Int,
    val type: String
)