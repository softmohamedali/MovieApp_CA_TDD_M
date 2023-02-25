package com.example.presentation.favorite.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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

@Composable
fun ListCinemaFavSeriesComponent (
    listTypeText:String="Popular Series",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<Series> = listOf(),
    onCardClick:(Int)->Unit
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = listTypeText,
            style = Typography.subtitle1,
            color = White
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp)
                .clickable { onMainActionClick() },
            text = mainActionText,
            style = Typography.caption,
            color = White
        )
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(listItems.size){
                CinemaCard(
                    name =listItems[it].name?:"",
                    image = listItems[it].posterPath.toString(),
                    rate = listItems[it].voteAverage.toString(),
                    id=listItems[it].id,
                    onCardClick = { id->
                        onCardClick(id)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}


@Composable
fun ListCinemaFavActorsComponent (
    listTypeText:String="Popular Actors",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<Actor> = listOf(),
    onCardClick:(Int)->Unit
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = listTypeText,
            style = Typography.subtitle1,
            color = White
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp)
                .clickable { onMainActionClick() },
            text = mainActionText,
            style = Typography.caption,
            color = White
        )
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(listItems.size){
                CinemaCard(
                    name =listItems[it].name,
                    image = listItems[it].profilePath,
                    showRate = false,
                    id=listItems[it].id,
                    onCardClick = {id->
                        onCardClick(id)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}



@Composable
fun ListCinemaFavMovieComponent (
    listTypeText:String="Popular Movie",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<Movie> = listOf(),
    onCardClick:(Int)->Unit
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = listTypeText,
            style = Typography.subtitle1,
            color = White
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp)
                .clickable { onMainActionClick() },
            text = mainActionText,
            style = Typography.caption,
            color = White
        )
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(listItems.size){ it ->
                CinemaCard(
                    name =listItems[it].originalTitle,
                    image = listItems[it].posterPath,
                    rate = listItems[it].voteAverage.toString(),
                    id=listItems[it].id,
                    onCardClick = {id->
                        onCardClick(id)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

