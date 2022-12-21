package com.example.domain.usecases

import com.example.core.domain.models.ResultState
import com.example.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(
    private val authRepo: AuthRepo
) {
    suspend operator fun invoke(email:String,pass:String,result:(ResultState<String>)->Unit){
        result(ResultState.IsLoading)
        authRepo.logIn(
            email = email,
            password = pass,
            result = {
                result(it)
            }
        )

    }
}