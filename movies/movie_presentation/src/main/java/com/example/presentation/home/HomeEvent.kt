package com.example.presentation.home

import com.example.domin.models.Movie

sealed class HomeEvent {

    object OnSwipeRefresh:HomeEvent()
}