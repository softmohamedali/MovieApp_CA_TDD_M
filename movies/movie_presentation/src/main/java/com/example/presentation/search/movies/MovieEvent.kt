package com.example.presentation.search.movies


sealed class MovieEvent {

    object OnSwipeRefresh: MovieEvent()
}