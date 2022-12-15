package com.example.core.domain.models


sealed class ResultState <out T>(
    val data: T? = null, var message: String? = null
){

    object Init: ResultState<Nothing>()
    object IsLoading: ResultState<Nothing>()
    class IsSucsses<T>(data: T?=null,message: String?=null): ResultState<T>(data,message)
    class IsError( msg: String): ResultState<Nothing>(null,msg)
}