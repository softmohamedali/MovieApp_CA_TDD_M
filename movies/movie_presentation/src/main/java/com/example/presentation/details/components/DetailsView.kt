package com.example.presentation.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.core.presentation.BackButton
import com.example.core.ui.CimaTextStyle
import com.example.core.ui.Main_Color
import com.example.core.ui.White
import com.example.domin.models.Movie
import com.example.domin.utils.MovieDomainConstants
import com.example.presentation.main.component.MainTopAppBar

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailsView(
    loading:Boolean,
    error:String?,
    movie: Movie,
    trailerUrl:String,
    onBackClick:()->Unit
) {
    val scrollState= rememberScrollState()
    val painterBackdrop = rememberImagePainter(
        data =  MovieDomainConstants.BASE_IMG_URL +movie.backdropPath,
    )
    val painterPoster = rememberImagePainter(
        data =  MovieDomainConstants.BASE_IMG_URL +movie.posterPath,
    )

    Scaffold(
        modifier=Modifier.fillMaxSize(),
        backgroundColor = Main_Color,
        topBar = {
            MainTopAppBar(
                actions = {
                    BackButton(
                        onBackClick = {
                            onBackClick()
                        }
                    )
                }
            )
        },
        content = { p->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(8.dp)
            ) {
                HeaderDetailsImages(
                    posterPath = painterPoster,
                    backPosterPath = painterBackdrop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text =movie.originalTitle,
                    style = CimaTextStyle.normalTitle,
                    color = White
                )
                Spacer(modifier = Modifier.height(20.dp))
                OneDetailsProperty(name = "Media Type", value ="Movie")
                Spacer(modifier = Modifier.height(10.dp))
                OneDetailsProperty(name = "Popularity", value ="${movie.popularity}")
                Spacer(modifier = Modifier.height(10.dp))
                OneDetailsProperty(name = "Vote", value ="${movie.voteAverage}")
                Spacer(modifier = Modifier.height(10.dp))
                OneDetailsProperty(name = "Vote Count", value ="${movie.voteCount}")
                Spacer(modifier = Modifier.height(10.dp))
                OneDetailsProperty(name = "Relesed Date", value = movie.releaseDate)
                Spacer(modifier = Modifier.height(10.dp))
                TypeMovieList(name = "Type", types =movie.remoteGenreMovies)
                Spacer(modifier = Modifier.height(10.dp))
                OneDetailsProperty(name = "Language", value = movie.originalLanguage)
                Spacer(modifier = Modifier.height(10.dp))
                OneDetailsProperty(name = "OverView", value = movie.overview)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text ="Trailer",
                    style = CimaTextStyle.normalTitle,
                    color = White
                )
                Spacer(modifier = Modifier.height(20.dp))
                YoutubeScreen(
                    videoId = trailerUrl,
                )
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    )

}