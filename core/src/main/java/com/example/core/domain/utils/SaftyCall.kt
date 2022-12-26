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
        return ResultState.IsError(UiText.StringResource(R.string.error_couldnt_reach_server).toString())
    } catch(e: HttpException) {
        return ResultState.IsError(UiText.StringResource(R.string.oops_something_went_wrong).toString())

    }
    catch (e:Exception){
        return ResultState.IsError(e.message?:UiText.unknownError().toString())
    }
}