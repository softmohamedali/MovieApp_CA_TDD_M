package com.example.presentation.favorite.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ui.Typography
import com.example.core.ui.White
import com.example.domin.models.Actor
import com.example.domin.models.Movie
import com.example.domin.models.Series
import com.example.presentation.component.CinemaCard
import com.example.presentation.component.SearchEditText
import com.example.presentation.home.component.*
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun FavoriteView(
    favMovies:List<Movie>,
    favSeries:List<Series>,
    favActor:List<Actor>,
    onFavMovieClick:(Int)->Unit,
    onFavSeriesClick:(Int)->Unit,
    onFavActorClick:(Int)->Unit,
){
    val scrollState= rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "My Favorite",
            style = Typography.subtitle1,
            color = White
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            ListCinemaFavMovieComponent(
                listItems = favMovies,
                onCardClick = {id->
                    onFavMovieClick(id)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ListCinemaFavSeriesComponent(
                listItems = favSeries,
                onCardClick = {id->
                    onFavSeriesClick(id)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ListCinemaFavActorsComponent(
                listItems = favActor,
                onCardClick = {id->
                    onFavActorClick(id)
                }
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}