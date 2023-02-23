package com.example.presentation.favorite

import com.example.domin.models.Actor
import com.example.domin.models.Movie
import com.example.domin.models.Series

data class FavoriteState(
    val errorFavMovie:String?=null,
    val errorFavActor:String?=null,
    val errorFavSeries:String?=null,
    val listFavMovies:List<Movie> = listOf(),
    val listFavSeries:List<Series> = listOf(),
    val listFavActors:List<Actor> = listOf(),

) {


}