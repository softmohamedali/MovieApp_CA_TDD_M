package com.example.presentation.home

import com.example.domin.usecases.RemoteMoviesUseCases
import io.mockk.impl.annotations.MockK

import org.junit.After
import org.junit.Before

class HomeViewModelTest {

    @MockK
    private lateinit var remoteMoviesUseCases: RemoteMoviesUseCases


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
}