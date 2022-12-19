package com.example.core.domain.utils

import java.util.regex.Pattern
data class ValidateState(
    var messge:String?=null,
    var valid:Boolean
){}

object ValidationUtils {
    fun isValidEmail(email: String?): ValidateState
    {
        if (email.isNullOrEmpty())
        {
            return ValidateState(valid = false,messge = "email is require")
        }
        if (!isEmail(email.trim()))
        {
            return ValidateState(valid = false,messge = "invalid email")
        }
        return ValidateState(valid = true)
    }
    private fun isEmail(email: CharSequence): Boolean {
        var isValid = true
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        if (!matcher.matches()) {
            isValid = false
        }
        return isValid
    }

    fun isValidPassword(password:String?): ValidateState
    {
        if (password.isNullOrEmpty())
        {
            return ValidateState(valid = false,messge = "password is require")
        }
        if (password.length<6)
        {
            return ValidateState(valid = false,messge = "password length most be more than 6")
        }
        val resultValidEmailContainDiggetOrLatter=password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if (!resultValidEmailContainDiggetOrLatter){
            return ValidateState(valid = false,messge = "password should contain at least one number or letter")
        }
        return ValidateState(valid = true)
    }

    fun isValidMobile(mobile:String?): ValidateState {
        if (mobile.isNullOrEmpty())
        {
            return ValidateState(valid = false,messge = "mobile is require")
        }
        when (mobile.length) {
            11 -> {
                val emailSplit = mobile.split("")

                val mobileFirstThreeNumber: String = emailSplit[1] + emailSplit[2] + emailSplit[3]
                if (mobileFirstThreeNumber == "010" || mobileFirstThreeNumber == "011" || mobileFirstThreeNumber == "012" || mobileFirstThreeNumber == "015")
                {
                    return ValidateState(valid = true)
                }else{
                    return ValidateState(valid = false,messge = "invalid number")
                }
            }
            else -> {
                return ValidateState(valid = false,messge = "invalid number")
            }
        }
    }
    fun isFieldEmpty(value:String?,fieldName:String): ValidateState {
        return if (value.isNullOrEmpty()){
            ValidateState(valid = false,messge = "$fieldName is require")
        }else{
            ValidateState(valid = true)
        }
    }
}