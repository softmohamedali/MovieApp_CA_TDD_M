package com.example.core.domain.utils

import com.example.core.domain.models.ResultState

suspend fun <T>safeCall(callBack:suspend ()->ResultState<T>):ResultState<T>{
    return try {
        callBack()
    }catch (e:Exception){
        log("exception"+e.message)
        return ResultState.IsError(e.message?:"Unkown Error")
    }
}