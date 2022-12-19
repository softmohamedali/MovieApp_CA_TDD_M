package com.example.presentation.register

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import com.example.core.domain.models.ResultState
import com.example.presentation.register.component.RegisterView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    navHostController: NavHostController,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val state = registerViewModel.state
    val scope= rememberCoroutineScope()
    RegisterView(
        email = state.email,
        emailError = state.emailError,
        password = state.password,
        passwordError = state.emailError,
        name = state.name,
        nameError = state.nameError,
        confirmPass = state.confirmPassword,
        confirmPasswordError = state.confirmPasswordError,
        termsChecked = state.termsChecked,
        termsError = state.termsError,
        onEmailChange = {
            registerViewModel.onEvent(RegisterEvent.EmailChanged(it))
        },
        onPasswordChange = {
            registerViewModel.onEvent(RegisterEvent.PasswordChanged(it))
        },
        onNameChange = {
            registerViewModel.onEvent(RegisterEvent.NameChanged(it))
        },
        onConfirmPassChange = {
            registerViewModel.onEvent(RegisterEvent.ConfirmPasswordChanged(it))
        },
        onTermsChange = {
            registerViewModel.onEvent(RegisterEvent.AcceptTermsChanged(it))
        },
        onRegisterClick = {
            registerViewModel.onEvent(RegisterEvent.RegisterSubmit)
        },
        isLoading = state.loading,
        isSuccess = state.success,
        isError = state.error,
        onSuccess = {
            scope.launch {
                delay(2000)
                navHostController.popBackStack()
            }
        }
    )

}