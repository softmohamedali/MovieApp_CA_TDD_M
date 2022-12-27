package com.example.presentation.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.presentation.ErrorView
import com.example.core.presentation.LoadingLayer
import com.example.domin.models.ActorItem
import com.example.domin.models.MovieItem
import com.example.domin.models.SeriesItem
import com.example.presentation.component.SearchEditText
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeView (
    loading:Boolean,
    error:String?=null,
    popularMovie:List<MovieItem> = listOf(),
    popularSeries:List<SeriesItem> = listOf(),
    popularActors:List<ActorItem> = listOf(),
    onSwipeToResfresh:()->Unit
){
    val scrollState= rememberScrollState()
    val swipeRefreshState = rememberSwipeRefreshState(loading)
    Box(modifier = Modifier.fillMaxSize()){


        if (loading){
            LoadingLayer()
        }else{
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = onSwipeToResfresh,
            ) {
                if(error!=null){
                    ErrorView(error)
                }else{
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        SearchEditText(readOnly = false) {}
                        Spacer(modifier = Modifier.height(30.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(scrollState)
                        ) {
                            ListCinemaMovieComponent(
                                listItems = popularMovie
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            ListCinemaSeriesComponent(
                                listItems = popularSeries
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            ListCinemaActorsComponent(
                                listItems = popularActors,
                            )
                            Spacer(modifier = Modifier.height(50.dp))
                        }
                    }
                }

            }
        }

    }


}