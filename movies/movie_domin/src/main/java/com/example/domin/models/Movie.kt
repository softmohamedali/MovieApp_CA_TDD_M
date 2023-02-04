package com.example.domin.models

data class Movie(
    val adult: Boolean=false,
    val backdropPath: String="",
    val budget: Int=-1,
    val remoteGenreMovies: List<GenreMovie> = listOf(),
    val homepage: String="",
    val id: Int=-1,
    val imdbId: String="",
    val originalLanguage: String="",
    val originalTitle: String="",
    val overview: String="",
    val popularity: Double=0.0,
    val posterPath: String="",
    val releaseDate: String="",
    val revenue: Int=-1,
    val runtime: Int=-1,
    val status: String="",
    val tagline: String="",
    val title: String="",
    val video: Boolean=false,
    val voteAverage: Double=0.0,
    val voteCount: Int=-1
)