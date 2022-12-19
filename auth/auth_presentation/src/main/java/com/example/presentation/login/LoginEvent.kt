package com.example.presentation.login

sealed class LoginEvent {
    data class EmailChanged(val email:String):LoginEvent()
    data class PasswordChanged(val password:String):LoginEvent()
    object LoginSubmit:LoginEvent()

}