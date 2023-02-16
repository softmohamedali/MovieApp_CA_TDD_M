package com.example.presentation.series

import com.example.domin.models.MovieItem
import com.example.domin.models.SeriesItem

data class SeriesState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val series:List<SeriesItem> = listOf(),
) {
}