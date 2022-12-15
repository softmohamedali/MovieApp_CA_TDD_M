package com.example.domain.repo

import com.example.core.domain.models.ResultState
import com.example.core.domain.models.User


interface AuthRepo {
    suspend fun registerUser(user: User, password: String): ResultState<String>
    suspend fun logIn(email:String,password:String): ResultState<String>
    suspend fun logout()
    fun getCurrentUser():String?
}