package com.example.data.local.localdto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domin.models.GenreMovie
import com.example.domin.utils.MovieDomainConstants


@Entity(tableName = MovieDomainConstants.MOVIE_ENTITY_NAME)
@kotlinx.serialization.Serializable
data class MovieLocal(
    val adult: Boolean = false,
    val backdropPath: String = "",
    val budget: Int = -1,
    val remoteGenreMovies: List<GenreMovie> = listOf(),
    val homepage: String = "",
    @PrimaryKey(autoGenerate = false)
    val id: Int = -1,
    val imdbId: String = "",
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val releaseDate: String = "",
    val revenue: Int = -1,
    val runtime: Int = -1,
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = 0.0,
    val voteCount: Int = -1
)