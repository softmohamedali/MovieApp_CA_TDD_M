package com.example.core.domain.utils

import coil.network.HttpException
import com.example.core.R
import com.example.core.domain.models.ResultState
import okio.IOException

suspend fun <T>safeCall(callBack:suspend ()->ResultState<T>):ResultState<T>{
    return try {
        callBack()
    }
    catch(e: IOException) {
        return ResultState.IsError("Oops! Couldn\'t reach server. Check your internet connection.")
    } catch(e: HttpException) {
        return ResultState.IsError("Oops! Something went wrong. Please try again.")

    }
    catch (e:Exception){
        return ResultState.IsError(e.message?:UiText.unknownError().toString())
    }
}