package com.example.domain.repo

import com.example.core.domain.models.ResultState
import com.example.core.domain.models.User


interface AuthRepo {
    suspend fun registerUser(user: User, password: String,result:(ResultState<String>)->Unit)
    suspend fun logIn(email:String,password:String,result:(ResultState<String>)->Unit)
    suspend fun logout()
    fun getCurrentUser():String?
}