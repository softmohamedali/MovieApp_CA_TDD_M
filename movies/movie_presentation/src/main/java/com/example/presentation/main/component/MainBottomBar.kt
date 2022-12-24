package com.example.presentation.main.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.ui.BG_trans_light
import com.example.core.ui.Bottom_Nav_Color
import com.example.core.ui.Main_Color
import com.example.core.ui.White
import com.example.domin.models.BottomBarScreen
import com.example.presentation.main.MainViewModel

@Composable
fun HomeBottomBar(
    viewModel: MainViewModel
){
    val screens= listOf<BottomBarScreen>(
        BottomBarScreen.SeriesPage,
        BottomBarScreen.MoviesPage,
        BottomBarScreen.HomePage,
        BottomBarScreen.ActorsPage,
        BottomBarScreen.FavoritesPage,
    )

    BottomAppBar(
        backgroundColor = Bottom_Nav_Color,
    ){
        for (i in screens.indices){
            AddItem(
                screen = screens[i],
                selected = viewModel.selectedTab.value==i
            ){
                viewModel.selectedTab.value=i
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    selected: Boolean,
    onClick:()->Unit,
){
    BottomNavigationItem(
        label = { Text(text = screen.label) },
        icon = { Icon(painter = painterResource(id =screen.icon ) , contentDescription = screen.label)},
        selected =selected ,
        onClick = {
            onClick()
        },
        selectedContentColor = White,
        unselectedContentColor = BG_trans_light

    )
}