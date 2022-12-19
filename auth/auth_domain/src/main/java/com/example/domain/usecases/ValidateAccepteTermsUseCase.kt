package com.example.domain.usecases

import com.example.core.domain.utils.ValidateState

class ValidateAccepteTermsUseCase() {
    operator fun invoke(accepted:Boolean): ValidateState {
        if (accepted){
            return ValidateState(valid = true)
        }else{
            return ValidateState(
                valid = false,
                messge = "Accepte terms"
            )
        }
    }
}