package com.example.core.domain.models


sealed class Screens(var route:String){

    object Login: Screens("login")
    object Register: Screens("register")
    object Main: Screens("main")
    object Splash: Screens("splash_screen")

    object Details: Screens("details/{id}"){
        fun navToDetailsWithId(id:Int):String{
            return "details/$id"
        }
    }


}
