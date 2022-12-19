package com.example.presentation.register


sealed class RegisterEvent {
    data class EmailChanged(val email:String): RegisterEvent()
    data class PasswordChanged(val password:String): RegisterEvent()
    data class NameChanged(val name:String): RegisterEvent()
    data class ConfirmPasswordChanged(val confirmPassword:String): RegisterEvent()
    data class AcceptTermsChanged(val accepted:Boolean): RegisterEvent()
    object RegisterSubmit: RegisterEvent()


}