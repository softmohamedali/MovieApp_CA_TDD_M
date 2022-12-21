package com.example.core.domain.utils

import android.util.Log
import androidx.navigation.NavHostController
import com.example.core.domain.models.ResultState
import kotlinx.coroutines.flow.flow

fun NavHostController.navOff(
    route: String,
){
    popBackStack()
    navigate(route = route)
}

fun log(str:String,tag:String="moali"){
    Log.d(tag,str)
}


suspend fun <T>safeHandledCall(callBack:suspend ()->Unit)= flow<ResultState<T>> {
    try {
        callBack()
    }catch (e:Exception){
        emit(ResultState.IsError("Error Accured : massage-> ${e.message}"))
    }
}