package com.example.presentation.details

import com.example.domin.models.Movie
import com.example.domin.models.MovieItem

data class DetailsState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val movieId:Int=-1,
    val movie:Movie?=null,
) {
}