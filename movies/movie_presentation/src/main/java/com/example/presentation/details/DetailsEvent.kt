package com.example.presentation.details

sealed class DetailsEvent {
    class SetMovieId(var id:Int):DetailsEvent()
}