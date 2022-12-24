package com.example.presentation.main.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.core.ui.Main_Color
import com.example.presentation.actors.ActorsScreen
import com.example.presentation.favorite.FavoritesScreen
import com.example.presentation.home.HomeScreen
import com.example.presentation.main.MainViewModel
import com.example.presentation.movies.MovieScreen
import com.example.presentation.series.SeriesScreen

@Composable
fun MainView(
    navHostController: NavHostController,
    mainViewModel: MainViewModel
) {

    Scaffold(
        backgroundColor = Main_Color,
        topBar = { MainTopAppBar() },
        bottomBar = {
            HomeBottomBar(mainViewModel)
        },
        content = {
            Crossfade(
                mainViewModel.selectedTab.value,
                modifier = Modifier.padding(it)
            ) { destination ->
                when (destination) {
                    0 -> {
                        SeriesScreen(
                            navHostController = navHostController,
                        )
                    }
                    1 -> {

                        MovieScreen(
                            navHostController = navHostController,
                        )
                    }
                    2 -> {
                        HomeScreen(
                            navHostController =navHostController,
                        )
                    }
                    3 -> {
                        ActorsScreen(
                            navHostController =navHostController,
                        )
                    }
                    4 -> {
                        FavoritesScreen(
                            navHostController =navHostController,
                        )
                    }
                }
            }
        }
    )
}