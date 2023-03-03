package com.example.presentation.series.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.presentation.ErrorView
import com.example.core.presentation.LoadingLayer
import com.example.domin.models.MovieItem
import com.example.domin.models.SeriesItem
import com.example.presentation.component.CinemaCard

@Composable
fun SeriesScreenView(
    onSeriesItemClick: (Int) -> Unit,
    series:List<SeriesItem>,
    loading:Boolean,
    error:String?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        if (loading){
            LoadingLayer()
        }else if (error!=null){
            ErrorView(errorText = "Error Accord $error")
        } else{
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                columns = GridCells.Fixed(2),
                content = {
                    items(series.size) {
                        CinemaCard(
                            modifier = Modifier.padding(5.dp),
                            name =series[it].name,
                            image = series[it].posterPath,
                            rate = series[it].voteAverage.toString(),
                            id=series[it].id,
                            onCardClick = {id->
                                onSeriesItemClick(id)
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                }
            )
        }
    }

}