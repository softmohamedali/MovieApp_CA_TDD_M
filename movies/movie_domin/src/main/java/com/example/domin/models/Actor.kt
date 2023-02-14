package com.example.domin.models

data class Actor(
    val adult: Boolean,
    val alsoKnownAs: List<Any>,
    val biography: String,
    val birthday: String,
    val deathday: Any?,
    val gender: Int,
    val homepage: Any?,
    val id: Int,
    val imdbId: String,
    val knownForDepartment: String,
    val name: String,
    val placeOfBirth: Any,
    val popularity: Double,
    val profilePath: Any
)
