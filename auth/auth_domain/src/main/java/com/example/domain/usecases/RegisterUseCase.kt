package com.example.domain.usecases

import com.example.core.domain.models.ResultState
import com.example.core.domain.models.User
import com.example.core.domain.utils.log
import com.example.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegisterUseCase(
    private val authRepo: AuthRepo
) {

    suspend operator fun invoke(name:String,email:String,pass:String,result:(ResultState<String>)->Unit ){
        log("registerUser RegisterUseCase")
        result(ResultState.IsLoading)
        val user= User(name,email,pass)
        authRepo.registerUser(user = user, password = pass,result={
            result(it)
        })
    }

}