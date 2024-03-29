package com.example.presentation.actors.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.presentation.SweetView
import com.example.domin.models.ActorItem
import com.example.presentation.component.CinemaCard

@Composable
fun ActorScreenView(
    onActorItemClick: (Int) -> Unit,
    actors:List<ActorItem>,
    error:String?,
    loading:Boolean
) {

    SweetView (
        error=error,
        loading=loading
    ){
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            columns = GridCells.Fixed(2),
            content = {
                items(actors.size) {
                    CinemaCard(
                        modifier = Modifier.padding(5.dp),
                        name =actors[it].name,
                        image = actors[it].profilePath,
                        rate = "6",
                        id=actors[it].id,
                        onCardClick = {id->
                            onActorItemClick(id)
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }

            }
        )
    }
}