package com.example.presentation.details.movie_detals

import com.example.domin.models.Movie

data class DetailsMovieState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val movieId:Int=-1,
    val movie:Movie=Movie(),
    val trailerUrl:String?=null,
) {
}