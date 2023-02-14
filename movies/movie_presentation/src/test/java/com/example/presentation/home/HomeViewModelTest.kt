package com.example.presentation.home

import com.example.domin.usecases.MoviesUseCases
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*

import org.junit.After
import org.junit.Before

class HomeViewModelTest {

    @MockK
    private lateinit var moviesUseCases: MoviesUseCases


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
}