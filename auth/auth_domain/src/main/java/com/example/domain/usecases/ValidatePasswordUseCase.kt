package com.example.domain.usecases

import com.example.core.domain.utils.ValidateState
import com.example.core.domain.utils.ValidationUtils
import dagger.hilt.android.scopes.ViewModelScoped

class ValidatePasswordUseCase(
) {
    operator fun invoke(email:String): ValidateState {
        return ValidationUtils.isValidPassword(email)
    }
}