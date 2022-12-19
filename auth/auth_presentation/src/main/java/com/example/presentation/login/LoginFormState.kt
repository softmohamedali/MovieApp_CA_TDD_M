package com.example.presentation.login

data class LoginFormState(
    val email:String="",
    val emailError:String?=null,
    val password:String="",
    val passwordError:String?=null,
    val success:Boolean=false,
    val error:String?=null,
    val loading:Boolean=false

)
