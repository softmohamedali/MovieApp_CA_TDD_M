package com.example.data.local.localdto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domin.models.GenreSeries
import com.example.domin.utils.MovieDomainConstants


@Entity(tableName = MovieDomainConstants.SERIES_ENTITY_NAME)
@kotlinx.serialization.Serializable
data class SeriesLocal(
    val backdropPath: String,
    val createdBy: List<String>,
    val episodeRunTime: List<Int>,
    val firstAirDate: String,
    val genres: List<GenreSeries>,
    val homepage: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val inProduction: Boolean,
    val languages: List<String>,
    val lastAirDate: String,
    val lastEpisodeToAir: String,
    val name: String,
    val networks: List<String>,
    val nextEpisodeToAir: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<String>,
    val productionCountries: List<String>,
    val seasons: List<String>,
    val status: String,
    val tagline: String,
    val type: String,
    val voteAverage: Double,
    val voteCount: Int
)