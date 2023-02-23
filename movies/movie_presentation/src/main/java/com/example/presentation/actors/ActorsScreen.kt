package com.example.presentation.actors

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.domain.models.Screens
import com.example.presentation.actors.component.ActorScreenView

@Composable
fun ActorsScreen(
    navHostController: NavHostController,
    viewModel: ActorViewModel= hiltViewModel()
) {
    val state = viewModel.state
    ActorScreenView(
        onActorItemClick = {
            navHostController.navigate(Screens.ActorDetails.navToActorDetailsWithId(it))
        },
        actors = state.actors
    )
}