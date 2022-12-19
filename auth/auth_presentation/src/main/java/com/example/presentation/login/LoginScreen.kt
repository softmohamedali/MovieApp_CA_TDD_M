package com.example.presentation.login

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.presentation.login.component.LoginView


@Composable
fun LoginScreen (
    navHostController: NavHostController,
    loginViewModel: LoginViewModel= hiltViewModel()
){
    val context = LocalContext.current
    val state = loginViewModel.state

    LoginView(
        email = state.email,
        password = state.password,
        isLoading = state.loading,
        isError = state.error,
        isSuccess = state.success,
        isEmailError = state.emailError != null,
        emailError = state.emailError,
        isPasswordError = state.passwordError != null,
        passwordError = state.passwordError,
        onPasswordChange = {
            loginViewModel.onEvent(LoginEvent.PasswordChanged(it))
        },
        onEmailChange = {
            loginViewModel.onEvent(LoginEvent.EmailChanged(it))
        },
        onLoginClick = {
            loginViewModel.onEvent(LoginEvent.LoginSubmit)
        },
        onRegisterClick = {
            navHostController.navigate(Screens.Register.route)
        },
        onSuccess = {
            navHostController.backQueue.clear()
            navHostController.navigate(Screens.Home.route)
            Toast.makeText(context, "succes Login", Toast.LENGTH_SHORT).show()
        }
    )
}