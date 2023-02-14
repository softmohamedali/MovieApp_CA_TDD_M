package com.example.presentation.details.series_details

import com.example.domin.models.Series

data class DetailsSeriesState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val seriesId:Int=-1,
    val series: Series?=null,
    val trailerUrl:String?=null,
) {
}