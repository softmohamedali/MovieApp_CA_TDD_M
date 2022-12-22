package com.example.data.mapper

import com.example.data.remote.dto.movie.RemoteGenreMovie
import com.example.data.remote.dto.movie.RemoteMovie
import com.example.data.remote.dto.movie.RemoteOneMovie
import com.example.domin.models.GenreMovie
import com.example.domin.models.Movie
import com.example.domin.models.MovieItem


fun RemoteOneMovie.toMovieItem(): MovieItem {
    return MovieItem(
        adult = this.adult,
        backdropPath = this.backdropPath,
        genreIds = this.genreIds,
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,

        )
}

fun List<RemoteOneMovie>.toListMovieItems(): List<MovieItem> {
    return this.map { it.toMovieItem() }
}

fun RemoteGenreMovie.toGenreMovie(): GenreMovie {
    return GenreMovie(this.id,this.name)
}

fun List<RemoteGenreMovie>.toListGenreSeries(): List<GenreMovie> {
    return this.map { it.toGenreMovie() }
}

fun RemoteMovie.toMovie(): Movie {
    return Movie(
        adult = this.adult,
        backdropPath = this.backdropPath,
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        budget = this.budget,
        remoteGenreMovies = this.remoteGenreMovies.toListGenreSeries(),
        homepage = this.homepage,
        imdbId = this.imdbId,
        revenue = this.revenue,
        runtime = this.runtime,
        status = this.status,
        tagline = this.tagline,
    )
}