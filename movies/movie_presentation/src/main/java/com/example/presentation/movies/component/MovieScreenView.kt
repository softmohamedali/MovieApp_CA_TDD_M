package com.example.presentation.movies.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.presentation.SweetView
import com.example.domin.models.MovieItem
import com.example.presentation.component.CinemaCard

@Composable
fun MovieScreenView(
    onMovieItemClick: (Int) -> Unit,
    movies:List<MovieItem>,
    error:String?,
    loading:Boolean
) {
    SweetView (
        error=error,
        loading=loading
    ){
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