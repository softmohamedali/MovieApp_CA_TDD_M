package com.example.data.mapper

import com.example.data.remote.dto.series.RemoteGenreSeries
import com.example.data.remote.dto.series.RemoteOneSeries
import com.example.data.remote.dto.series.RemoteSeries
import com.example.domin.models.*

fun RemoteOneSeries.toSeriesItem(): SeriesItem {
    return SeriesItem(
        backdropPath = this.backdropPath,
        firstAirDate = this.firstAirDate,
        genreIds = this.genreIds,
        id = this.id,
        name = this.name,
        originCountry = this.originCountry,
        originalLanguage = this.originalLanguage,
        originalName = this.originalName,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}

fun List<RemoteOneSeries>.toListSeriesItems(): List<SeriesItem> {
    return this.map { it.toSeriesItem() }
}

fun RemoteGenreSeries.toGenreSeries(): GenreSeries {
    return GenreSeries(this.id, this.name)
}

fun List<RemoteGenreSeries>.toListGenreSeries(): List<GenreSeries> {
    return this.map { it.toGenreSeries() }
}

fun RemoteSeries.toSeries(): Series {
    return Series(
        backdropPath = this.backdropPath,
        id = this.id,
        originalLanguage = this.originalLanguage,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        homepage = this.homepage,
        status = this.status,
        tagline = this.tagline,
        createdBy = this.createdBy,
        episodeRunTime = this.episodeRunTime,
        firstAirDate = this.firstAirDate,
        genres = this.genres.toListGenreSeries(),
        inProduction = this.inProduction,
        languages = this.languages,
        lastAirDate = this.lastAirDate,
        lastEpisodeToAir = this.lastEpisodeToAir,
        name = this.name,
        networks = this.networks,
        nextEpisodeToAir = this.nextEpisodeToAir,
        numberOfEpisodes = this.numberOfEpisodes,
        numberOfSeasons = this.numberOfSeasons,
        originCountry = this.originCountry,
        originalName = this.originalName,
        productionCompanies = this.productionCompanies,
        productionCountries = this.productionCountries,
        seasons = this.seasons,
        type = this.type,
    )
}