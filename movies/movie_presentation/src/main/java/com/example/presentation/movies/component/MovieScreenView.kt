package com.example.presentation.movies.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.presentation.ErrorView
import com.example.core.presentation.LoadingLayer
import com.example.core.ui.BG_trans_light
import com.example.core.ui.CimaTextStyle
import com.example.core.ui.White
import com.example.domin.models.Movie
import com.example.domin.models.MovieItem
import com.example.presentation.component.CinemaCard

@Composable
fun MovieScreenView(
    onMovieItemClick: (Int) -> Unit,
    movies:List<MovieItem>,
    error:String?,
    loading:Boolean
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
                    items(movies.size) {
                        CinemaCard(
                            modifier = Modifier.padding(5.dp),
                            name =movies[it].originalTitle,
                            image = movies[it].posterPath,
                            rate = movies[it].voteAverage.toString(),
                            id=movies[it].id,
                            onCardClick = {id->
                                onMovieItemClick(id)
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                }
            )
        }
    }


}