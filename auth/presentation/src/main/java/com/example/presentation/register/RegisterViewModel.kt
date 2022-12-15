package com.example.presentation.register

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
):ViewModel(){
}