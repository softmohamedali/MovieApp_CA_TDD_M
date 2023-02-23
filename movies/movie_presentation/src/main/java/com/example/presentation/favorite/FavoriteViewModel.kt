package com.example.presentation.favorite

import androidx.lifecycle.ViewModel
import com.example.domin.usecases.RemoteMoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    val useCases: RemoteMoviesUseCases
):ViewModel() {
}