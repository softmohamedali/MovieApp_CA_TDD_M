package com.example.presentation.home.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.component.SearchText

@Composable
fun HomeView (){
    val scrollState= rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        SearchText() {}
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            ListCinemaComponent()
            Spacer(modifier = Modifier.height(10.dp))
            ListCinemaComponent()
            Spacer(modifier = Modifier.height(10.dp))
            ListCinemaComponent()
            Spacer(modifier = Modifier.height(50.dp))
        }
    }

}