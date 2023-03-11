package com.example.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.core.presentation.Center
import com.example.core.presentation.utils.ContentsDescriptions
import com.example.core.ui.BG_trans_light
import com.example.core.ui.Loading_Back

@Composable
fun LoadingLayer() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Loading_Back
    ) {
        Center {
            CircularProgressIndicator(
                modifier = Modifier.semantics {
                     this.contentDescription=ContentsDescriptions.PROGRESS_BAR
                },
                color = BG_trans_light
            )
        }
    }
}