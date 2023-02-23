package com.example.presentation.details.actors_details

import com.example.domin.models.Actor
import com.example.domin.models.Series

data class DetailsActorState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val actorId:Int=-1,
    val actor: Actor?=null,
    val trailerUrl:String?=null,
    val isFav:Boolean=false
) {
}