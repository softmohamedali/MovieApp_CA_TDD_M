package com.example.core.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.ui.Loading_Back
import com.example.core.ui.None

@Composable
fun LoadingLayer() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Loading_Back
    ) {
        Center { CircularProgressIndicator() }
    }
}