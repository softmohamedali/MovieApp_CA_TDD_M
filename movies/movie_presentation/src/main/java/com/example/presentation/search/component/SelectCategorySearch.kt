package com.example.presentation.search.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.core.presentation.MyOutLineButton
import com.example.core.ui.BG_trans_light
import com.example.presentation.search.CategorySearch

@Composable
fun SelectCategorySearch (
    onMovieClick:()->Unit,
    onSeriesClick:()->Unit,
    onActorClick:()->Unit,
    categorySearch: CategorySearch
){
    val buttonSelected by remember {
        mutableStateOf(
            mutableStateListOf(
                categorySearch==CategorySearch.MOVIE,
                categorySearch==CategorySearch.SERIES,
                categorySearch==CategorySearch.ACTOR,
            )
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        MyOutLineButton(
            text = "Movie",
            modifier = Modifier.weight(1f),
            backgroundColor = if(buttonSelected[0])
                BG_trans_light
            else
                Color.White,
            textColor =if(buttonSelected[0])
                Color.White
            else
                BG_trans_light,
            onclick = {
                buttonSelected[0]=true
                buttonSelected[1]=false
                buttonSelected[2]=false
                onMovieClick()
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        MyOutLineButton(
            text = "Series",
            modifier = Modifier.weight(1f),
            backgroundColor =  if(buttonSelected[1])
                BG_trans_light
            else
                Color.White,
            textColor =  if(buttonSelected[1])
                Color.White
            else
                BG_trans_light,
            onclick = {
                buttonSelected[0]=false
                buttonSelected[1]=true
                buttonSelected[2]=false
                onSeriesClick()
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        MyOutLineButton(
            text = "Actor",
            modifier = Modifier.weight(1f),
            backgroundColor =  if(buttonSelected[2])
                BG_trans_light
            else
                Color.White,
            textColor =  if(buttonSelected[2])
                Color.White
            else
                BG_trans_light,
            onclick = {
                buttonSelected[0]=false
                buttonSelected[1]=false
                buttonSelected[2]=true
                onActorClick()
            }
        )

    }
}
