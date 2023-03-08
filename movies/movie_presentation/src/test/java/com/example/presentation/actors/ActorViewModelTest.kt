package com.example.presentation.actors

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domin.usecases.RemoteMoviesUseCases
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.*

import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class ActorViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    val dispatcher = StandardTestDispatcher()
    private lateinit var useCases: RemoteMoviesUseCases
    private lateinit var actorViewModel: ActorViewModel

    @Before
    fun setUp() {
        useCases= mock()
        actorViewModel=ActorViewModel(useCases,dispatcher)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `when create viewmodel verify first state`(){
        val myState=ActorState()
        Assert.assertEquals(myState,actorViewModel.state)
    }
}
