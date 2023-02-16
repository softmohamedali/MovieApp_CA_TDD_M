package com.example.presentation.movies


sealed class MovieEvent {

    object OnSwipeRefresh:MovieEvent()
}