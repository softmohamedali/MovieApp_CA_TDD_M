package com.example.domin.usecases.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.core.domain.models.ResultState
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class GetPopularActorUseCaseTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()



    val dispatcher = StandardTestDispatcher()
    private lateinit var useCases: GetPopularActorUseCase
    private lateinit var repositry: MoviesRepositry

    @Before
    fun setUp() {
        repositry= mock()
        useCases= GetPopularActorUseCase(repositry)
    }



    @After
    fun tearDown() {
    }

    @Test
    fun `when execute should call repo method getPopularActor`()= runTest{
        val has= hashMapOf<String,String>()
        useCases(has).collect{}
        verify(repositry).getPopularActor(has)
    }


}