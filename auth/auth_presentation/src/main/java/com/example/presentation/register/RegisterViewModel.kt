package com.example.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.models.ResultState
import com.example.core.domain.utils.DateTimeFormated
import com.example.core.domain.utils.ValidateState
import com.example.core.domain.utils.log
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
) : ViewModel() {

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
            is RegisterEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }
            is RegisterEvent.RegisterSubmit -> {
                registerSubmit()
            }

        }
    }

    private fun registerSubmit() {
        log("registerSubmit Register viewmodel ")
        viewModelScope.launch {
            val validateEmailResult = validateEmailUseCase(state.email)
            val validatePasswordResult = validatePasswordUseCase(state.password)
            val validateConfirmPasswordResult = validateConfirmPasswordUseCase(
                state.password,
                state.confirmPassword
            )
            val validateShopNameResult = if (state.name.isEmpty()) {
                ValidateState(valid = false, messge = "Shop Name is require")
            } else {
                ValidateState(valid = true)
            }
            val validateTermsResult = validateAccepteTermsUseCase(state.termsChecked)
            val hasError = listOf(
                validateEmailResult,
                validatePasswordResult,
                validateConfirmPasswordResult,
                validateTermsResult,
                validateShopNameResult
            ).any { !it.valid }
            if (hasError) {
                log("registerSubmit Register viewmodel has error ")
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

    private suspend fun register() = withContext(Dispatchers.IO) {
        log("register Register viewmodel ")

        registerUseCase(
            email = state.email,
            pass = state.password,
            name = state.name,
        ){
            log("register Register viewmodel collect ${it} ")
            when (it) {
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
                        error = it.message
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

    private fun clearState() {
        state = state.copy(
            success = false,
            loading = false,
            error = null,
            email="",
        emailError=null,
        password="",
        passwordError=null,
        name="",
        nameError=null,
        confirmPassword="",
        confirmPasswordError=null,
        termsChecked=false,
        termsError=null,
        )
    }

    override fun onCleared() {
        super.onCleared()
        _isRegister.value = ResultState.Init
    }
}