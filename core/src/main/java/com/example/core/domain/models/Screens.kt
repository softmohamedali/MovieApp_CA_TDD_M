package com.example.core.domain.models


sealed class Screens(var route:String){

    object Login: Screens("login")
    object Register: Screens("register")
    object Main: Screens("main")
    object Splash: Screens("splash_screen")

    object MovieDetails: Screens("movie_details/{id}"){
        fun navToMovieDetailsWithId(id:Int):String{
            return "movie_details/$id"
        }
    }
    object SeriesDetails: Screens("series_details/{id}"){
        fun navToSeriesDetailsWithId(id:Int):String{
            return "series_details/$id"
        }
    }
    object ActorDetails: Screens("actor_details/{id}"){
        fun navToActorDetailsWithId(id:Int):String{
            return "actor_details/$id"
        }
    }


}
