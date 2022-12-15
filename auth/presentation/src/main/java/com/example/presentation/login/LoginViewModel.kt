package com.example.presentation.login

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) :ViewModel() {

}