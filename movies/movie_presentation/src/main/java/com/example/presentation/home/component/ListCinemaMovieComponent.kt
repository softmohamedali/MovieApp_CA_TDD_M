package com.example.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ui.Typography
import com.example.core.ui.White
import com.example.domin.models.ActorItem
import com.example.domin.models.MovieItem
import com.example.domin.models.SeriesItem
import com.example.presentation.component.CinemaCard

@Composable
fun ListCinemaMovieComponent (
    listTypeText:String="Popular Movie",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<MovieItem> = listOf(),
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


@Composable
fun ListCinemaSeriesComponent (
    listTypeText:String="Popular Series",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<SeriesItem> = listOf()
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
                    image = listItems[it].posterPath?:"",
                    rate = listItems[it].voteAverage.toString(),
                    id=listItems[it].id,
                    onCardClick = {

                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}


@Composable
fun ListCinemaActorsComponent (
    listTypeText:String="Popular Actors",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<ActorItem> = listOf()
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
                    onCardClick = {

                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}