package com.example.domain.usecases

import com.example.core.domain.utils.ValidateState

class ValidateConfirmPasswordUseCase(
) {
    operator fun invoke(password:String,confirmPassword:String): ValidateState {
        if (password!=confirmPassword){
            return ValidateState(
                messge = "invalid confirm password",
                valid = false
            )
        }else{
            return ValidateState(
                valid = true
            )
        }
    }
}