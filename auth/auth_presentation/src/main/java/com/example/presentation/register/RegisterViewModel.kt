package com.example.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.DateTimeFormated
import com.example.core.domain.utils.ValidateState
import com.example.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateConfirmPasswordUseCase: ValidateConfirmPasswordUseCase,
    private val validateAccepteTermsUseCase: ValidateAccepteTermsUseCase
) : ViewModel(){

    private var _isRegister = MutableStateFlow<ResultState<String>>(ResultState.Init)
    val isRegister: StateFlow<ResultState<String>> = _isRegister

    var state by mutableStateOf(RegisterFormState())

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegisterEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegisterEvent.ConfirmPasswordChanged -> {
                state = state.copy(confirmPassword = event.confirmPassword)
            }
            is RegisterEvent.AcceptTermsChanged -> {
                state = state.copy(termsChecked = event.accepted)
            }
            is RegisterEvent.NameChanged ->{
                state = state.copy(name = event.name)
            }
            is RegisterEvent.RegisterSubmit -> {
                registerSubmit()
            }

        }
    }

    private fun registerSubmit() {
        viewModelScope.launch {
            val validateEmailResult = validateEmailUseCase(state.email)
            val validatePasswordResult = validatePasswordUseCase(state.password)
            val validateConfirmPasswordResult = validateConfirmPasswordUseCase(
                state.password,
                state.confirmPassword
            )
            val validateNameResult=ValidateState(if (state.name.isEmpty()) "Name is required" else null,state.name.isEmpty())
            val validateTermsResult = validateAccepteTermsUseCase(state.termsChecked)
            val hasError = listOf(
                validateEmailResult,
                validatePasswordResult,
                validateConfirmPasswordResult,
                validateTermsResult,
                validateNameResult
            ).any { !it.valid }
            if (hasError) {
                state = state.copy(
                    emailError = validateEmailResult.messge,
                    passwordError = validatePasswordResult.messge,
                    confirmPasswordError = validateConfirmPasswordResult.messge,
                    termsError = validateTermsResult.messge
                )
                return@launch
            }
            register()
        }
    }

    private suspend fun register()=withContext(Dispatchers.IO) {
        registerUseCase(
            email = state.email,
            pass = state.password,
            name = state.name,
            ).collect {
                _isRegister.emit(it)
            }
        }


    override fun onCleared() {
        super.onCleared()
        _isRegister.value = ResultState.Init
    }
}