package com.example.presentation.actors

import com.example.domin.models.ActorItem
import com.example.domin.models.MovieItem

data class ActorState(
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val actors:List<ActorItem> = listOf(),
) {
}