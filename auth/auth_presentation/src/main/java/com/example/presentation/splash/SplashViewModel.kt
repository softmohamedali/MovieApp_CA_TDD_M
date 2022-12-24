package com.example.presentation.splash

import androidx.lifecycle.ViewModel
import com.example.domain.repo.AuthRepo
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private  val authRepo: AuthRepo
):ViewModel(){


    fun getCurrentUser()=authRepo.getCurrentUser()

}