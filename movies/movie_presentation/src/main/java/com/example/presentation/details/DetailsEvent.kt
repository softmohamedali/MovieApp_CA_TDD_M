package com.example.presentation.details

sealed class DetailsEvent {
    class StartScreenSetMovieId(var id:Int):DetailsEvent()
    class StartScreenSetSeriesId(var id:Int):DetailsEvent()
    class StartScreenSetActorId(var id:Int):DetailsEvent()

    object InsetMovieFav : DetailsEvent()
    object InsetSeriesFav : DetailsEvent()
    object InsetActorFav : DetailsEvent()



}