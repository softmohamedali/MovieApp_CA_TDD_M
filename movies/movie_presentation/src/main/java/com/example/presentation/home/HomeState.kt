package com.example.presentation.home

import com.example.domin.models.*

data class HomeState(
    val loadingPM:Boolean=false,
    val loadingPS:Boolean=false,
    val loadingPA:Boolean=false,
    val successPM:Boolean=false,
    val successPS:Boolean=false,
    val successPA:Boolean=false,
    val errorPM:String?=null,
    val errorPS:String?=null,
    val errorPA:String?=null,
    val popularMovies:List<MovieItem> = listOf(),
    val popularSeries:List<SeriesItem> = listOf(),
    val popularActor:List<ActorItem> = listOf(),

) {
}