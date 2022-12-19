package com.example.presentation.register

data class RegisterFormState(
    val success:Boolean=false,
    val error:String?=null,
    val loading:Boolean=false,
    val email:String="",
    val emailError:String?=null,
    val password:String="",
    val passwordError:String?=null,
    val name:String="",
    val nameError:String?=null,
    val confirmPassword:String="",
    val confirmPasswordError: String?=null,
    val termsChecked:Boolean=false,
    val termsError:String?=null,
)
