package com.example.presentation.details.components

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ui.BG_trans_light
import com.example.core.ui.White
import com.example.domin.models.GenreMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch



@Composable
fun TypeMovieList(
    types:List<GenreMovie>,
){

    LazyVerticalGrid(
        userScrollEnabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        columns = GridCells.Fixed(3),
        content ={
            items(types.size){
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .background(BG_trans_light)
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                    ,
                    text =types[it].name,
                    color = White
                )
            }

        }
    )


}