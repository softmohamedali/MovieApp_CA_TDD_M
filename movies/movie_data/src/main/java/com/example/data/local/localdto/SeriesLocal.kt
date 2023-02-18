package com.example.data.local.localdto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domin.utils.MovieDomainConstants


@Entity(tableName = MovieDomainConstants.SERIES_ENTITY_NAME)
@kotlinx.serialization.Serializable
data class SeriesLocal(
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)