package com.example.presentation.actors

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.core.presentation.utils.ContentsDescriptions
import com.example.movie_app_compose.ui.theme.Movie_app_composeTheme
import com.example.presentation.actors.component.ActorScreenView
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ActorScreenTest {

    @get:Rule
    val testRule: ComposeContentTestRule = createComposeRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadingState_renderProgressIndicator(){
        testRule.setContent {
            Movie_app_composeTheme{
                ActorScreenView(
                    onActorItemClick ={} ,
                    actors = emptyList() ,
                    error = null,
                    loading =true
                )
            }
        }
        testRule.onNodeWithContentDescription(ContentsDescriptions.PROGRESS_BAR)
            .assertIsDisplayed()
    }
}