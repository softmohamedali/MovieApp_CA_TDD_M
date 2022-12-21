package com.example.domin.models

data class ActorItem(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    val profilePath: String
)