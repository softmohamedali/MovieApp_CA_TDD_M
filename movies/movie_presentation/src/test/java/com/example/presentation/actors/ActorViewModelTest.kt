package com.example.presentation.actors

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.core.domain.models.ResultState
import com.example.domin.models.Actor
import com.example.domin.usecases.remote.GetPopularActorUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.*
import org.mockito.kotlin.any

import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class ActorViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()


    private val dispatcher = StandardTestDispatcher()
    private lateinit var useCases: GetPopularActorUseCase
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
        whenever(useCases(any()))
            .thenReturn(flowOf(ResultState.IsSucsses(listOf())))
        dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true,actorViewModel.state.success)
        Assert.assertEquals(null,actorViewModel.state.error)
        Assert.assertEquals(false,actorViewModel.state.loading)
        Assert.assertEquals(listOf<Actor>(),actorViewModel.state.actors)
    }


    @Test
    fun `when use case emit loading should state be loading`()= runTest{
        whenever(useCases(any()))
            .thenReturn(flowOf(ResultState.IsLoading))
        dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(false,actorViewModel.state.success)
        Assert.assertEquals(null,actorViewModel.state.error)
        Assert.assertEquals(true,actorViewModel.state.loading)
        Assert.assertEquals(listOf<Actor>(),actorViewModel.state.actors)
    }


    @Test
    fun `when use case emit error should state be erroe`()= runTest{
        val errorMassage="error"
        whenever(useCases(any()))
            .thenReturn(flowOf(ResultState.IsError(errorMassage)))
        dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(false,actorViewModel.state.success)
        Assert.assertEquals(errorMassage,actorViewModel.state.error)
        Assert.assertEquals(false,actorViewModel.state.loading)
        Assert.assertEquals(listOf<Actor>(),actorViewModel.state.actors)
    }
}
