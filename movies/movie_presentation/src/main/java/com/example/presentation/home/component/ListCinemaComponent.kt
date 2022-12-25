package com.example.presentation.home.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ui.Typography
import com.example.core.ui.White
import com.example.presentation.component.CinemaCard

@Composable
fun ListCinemaComponent (
    listTypeText:String="Popular Movie",
    mainActionText:String="<< See All",
    onMainActionClick:()->Unit={},
    listItems:List<Any> = listOf()
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = listTypeText,
            style = Typography.subtitle1,
            color = White
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp)
                .clickable { onMainActionClick() },
            text = mainActionText,
            style = Typography.caption,
            color = White
        )
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(10){
                CinemaCard()
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}