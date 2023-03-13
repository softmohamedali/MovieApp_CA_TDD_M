package com.example.presentation.search.movies

import com.example.domin.models.ActorItem
import com.example.domin.models.MovieItem
import com.example.domin.models.SeriesItem

data class MovieState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val movies:List<MovieItem> = listOf(),
) {
}