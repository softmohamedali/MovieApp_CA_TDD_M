package com.example.presentation.search

import com.example.domin.models.*

data class SearchScreenState(
    val loading:Boolean=false,
    val error:String?=null,
    val success:Boolean=false,
    val searchMovie:List<MovieItem> = listOf(),
    val searchSeries:List<SeriesItem> = listOf(),
    val searchActor:List<ActorItem> = listOf(),
    val searchCategory:CategorySearch =CategorySearch.MOVIE
)