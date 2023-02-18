package com.example.data.local.localdto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domin.utils.MovieDomainConstants


@Entity(tableName = MovieDomainConstants.MOVIE_ENTITY_NAME)
@kotlinx.serialization.Serializable
data class MovieLocal(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)