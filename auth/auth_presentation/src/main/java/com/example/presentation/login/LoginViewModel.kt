package com.example.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.domain.usecases.LoginUseCase
import com.example.domain.usecases.ValidateEmailUseCase
import com.example.domain.usecases.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {

    var state by mutableStateOf(LoginFormState())

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is LoginEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is LoginEvent.LoginSubmit -> {
                logInSubmit()
            }
        }
    }

    private fun logInSubmit() {
        viewModelScope.launch {
            val validateEmailResult = validateEmailUseCase(state.email)
            val validatepasswordResult = validatePasswordUseCase(state.password)
            val hasError = listOf(
                validateEmailResult,
                validatepasswordResult
            ).any { !it.valid }
            if (hasError) {
                state = state.copy(
                    emailError = "validateEmailResult.messge",
                    passwordError = validatepasswordResult.messge
                )
                return@launch
            }
            login()
        }
    }

    private suspend fun login() = withContext(Dispatchers.IO) {
        loginUseCase(state.email, state.password).collect { result ->
            when (result) {
                is ResultState.IsSucsses -> {
                    state = state.copy(
                        success = true,
                        loading = false,
                        error = null
                    )
                }
                is ResultState.IsError -> {
                    state = state.copy(
                        success = false,
                        loading = false,
                        error = result.message
                    )
                }
                is ResultState.IsLoading -> {
                    state = state.copy(
                        success = false,
                        loading = true,
                        error = null
                    )
                }
            }
        }
    }

    private fun cleanState() {
        state = state.copy(
            email = "",
            emailError = null,
            password = "",
            passwordError = null,
            success = false,
            error = null,
            loading = false
        )
    }

    override fun onCleared() {
        super.onCleared()
        cleanState()
    }
}