package com.example.domain.usecases

import com.example.core.domain.utils.ValidateState
import com.example.core.domain.utils.ValidationUtils

class ValidatePhoneUseCase() {
    operator fun invoke(phone:String): ValidateState {
        return ValidationUtils.isValidMobile(phone)
    }
}