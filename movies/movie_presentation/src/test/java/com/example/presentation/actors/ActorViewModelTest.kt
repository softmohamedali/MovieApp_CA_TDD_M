package com.example.presentation.actors

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.core.domain.models.ResultState
import com.example.domin.usecases.RemoteMoviesUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.*
import org.mockito.kotlin.any

import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

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
        actorViewModel=ActorViewModel(useCases,dispatcher,dispatcher)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `when create viewmodel verify first state`(){
        val myState=ActorState()
        Assert.assertEquals(myState,actorViewModel.state)
    }

    @Test
    fun `when use case emit success should state be success`()= runTest{
        whenever(useCases.getPopularActorUseCase(any()))
            .thenReturn(flow{ emit(ResultState.IsSucsses(any())) })
        advanceUntilIdle()
        Assert.assertEquals(true,actorViewModel.state.success)
    }
}
