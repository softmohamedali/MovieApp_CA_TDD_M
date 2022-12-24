package com.example.domin.models

import com.example.movie_domin.R


sealed class BottomBarScreen(
    val label:String,
    val route:String,
    val icon: Int
){
    object SeriesPage: BottomBarScreen("Series","sells", com.example.core.R.drawable.ic_series)
    object MoviesPage: BottomBarScreen("Movies","products",com.example.core.R.drawable.ic_movie)
    object HomePage: BottomBarScreen("Home","setting",com.example.core.R.drawable.ic_home)
    object ActorsPage: BottomBarScreen("Actors","setting",com.example.core.R.drawable.ic_person)
    object FavoritesPage: BottomBarScreen("FAV","setting",com.example.core.R.drawable.ic_favorite)

}
