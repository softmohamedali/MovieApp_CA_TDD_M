package com.example.core.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SweetView(
    error:String?=null,
    loading:Boolean=false,
    content:@Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        if (loading){
            LoadingLayer()
        }else if (error!=null){
            ErrorView(errorText = "Error Accord $error")
        } else{
            content()
        }
    }
}