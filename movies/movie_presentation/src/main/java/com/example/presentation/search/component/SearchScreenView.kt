package com.example.presentation.search.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.presentation.*
import com.example.core.ui.*
import com.example.domin.models.ActorItem
import com.example.domin.models.MovieItem
import com.example.domin.models.SeriesItem
import com.example.presentation.component.CinemaCard
import com.example.presentation.component.SearchEditText
import com.example.presentation.details.components.HeaderDetailsImages
import com.example.presentation.details.components.OneDetailsProperty
import com.example.presentation.details.components.TypeMovieList
import com.example.presentation.details.components.YoutubeScreen
import com.example.presentation.main.component.MainTopAppBar
import com.example.presentation.search.CategorySearch

@Composable
fun SearchScreenView(
    onSearchTextChange:(String)->Unit,
    onSearchClick:()->Unit,
    onMovieCategoryClick:()->Unit,
    onSeriesCategoryClick:()->Unit,
    onActorCategoryClick:()->Unit,
    searchText:String,
    categorySearch: CategorySearch,
    listMovie:List<MovieItem>,
    listSeries:List<SeriesItem>,
    listActor:List<ActorItem>,
    onActorItemClick:(Int)->Unit,
    onSeriesItemClick:(Int)->Unit,
    onMovieItemClick:(Int)->Unit,
    onBackClick:()->Unit,
    loading:Boolean,
    error:String?=null,

) {




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

            SweetView (
                error=error,
                loading=loading
            ){
                Column (
                    modifier = Modifier.fillMaxSize()
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SearchEditText(
                            myModifier = Modifier.weight(8f),
                            onTextChange = onSearchTextChange,
                            value = searchText, enable = true
                        )
                        FloatingActionButton(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            onClick = onSearchClick,
                            content = {
                                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Click")
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    SelectCategorySearch(
                        onMovieClick = onMovieCategoryClick,
                        onSeriesClick = onSeriesCategoryClick,
                        onActorClick = onActorCategoryClick,
                        categorySearch=categorySearch
                    )

                    if (categorySearch==CategorySearch.ACTOR){
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxWidth(),
                            columns = GridCells.Fixed(2),
                            content = {
                                items(listActor.size) {
                                    CinemaCard(
                                        modifier = Modifier.padding(5.dp),
                                        name =listActor[it].name,
                                        image = listActor[it].profilePath,
                                        rate = "6",
                                        id=listActor[it].id,
                                        onCardClick = {id->
                                            onActorItemClick(id)
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                }

                            }
                        )
                    }
                    if (categorySearch==CategorySearch.MOVIE){
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxWidth(),
                            columns = GridCells.Fixed(2),
                            content = {
                                items(listMovie.size) {
                                    CinemaCard(
                                        modifier = Modifier.padding(5.dp),
                                        name =listMovie[it].originalTitle,
                                        image = listMovie[it].posterPath,
                                        rate = listMovie[it].voteAverage.toString(),
                                        id=listMovie[it].id,
                                        onCardClick = {id->
                                            onMovieItemClick(id)
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                }

                            }
                        )
                    }
                    if (categorySearch==CategorySearch.SERIES){
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxWidth(),
                            columns = GridCells.Fixed(2),
                            content = {
                                items(listSeries.size) {
                                    CinemaCard(
                                        modifier = Modifier.padding(5.dp),
                                        name =listSeries[it].name,
                                        image = listSeries[it].posterPath,
                                        rate = listSeries[it].voteAverage.toString(),
                                        id=listSeries[it].id,
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



        }
    )
}