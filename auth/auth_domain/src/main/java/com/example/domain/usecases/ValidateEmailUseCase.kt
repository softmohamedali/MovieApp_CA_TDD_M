package com.example.domain.usecases

import com.example.core.domain.utils.ValidateState
import com.example.core.domain.utils.ValidationUtils

class ValidateEmailUseCase(
) {
    operator fun invoke(email:String): ValidateState {
        return ValidationUtils.isValidEmail(email)
    }
}