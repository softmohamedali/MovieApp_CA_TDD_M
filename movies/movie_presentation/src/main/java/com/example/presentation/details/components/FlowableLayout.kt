package com.example.presentation.details.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable

@Composable
fun FlowableLayout(
    modifier: Modifier,
    content:@Composable ()->Unit
) {
    Layout(
        modifier=modifier,
        measurePolicy ={measurable,constraint ->
            val placeable=measurable.map {
                it.measure(constraint)
            }
            val groupPlaceable= mutableListOf<List<Placeable>>()
            var currentGroup= mutableListOf<Placeable>()
            var currentGroupWidth=0

            placeable.forEach {
                if (currentGroupWidth+it.width<=constraint.maxWidth){
                    currentGroup.add(it)
                    currentGroupWidth+=it.width
                }else{
                    groupPlaceable.add(currentGroup)
                    currentGroup= mutableListOf(it)
                    currentGroupWidth=it.width
                }
            }

            if(currentGroup.isNotEmpty()){
                groupPlaceable.add(currentGroup)
            }
            layout(
                width = constraint.maxWidth,
                height = constraint.maxHeight
            ){
                var yPosition=0
                groupPlaceable.forEach {row->
                    var xPosition=0
                    row.forEach {
                        it.place(
                            y = yPosition,
                            x=xPosition
                        )
                        xPosition+=it.width
                    }
                    yPosition+=row.first().height
                }
            }
        },
        content=content
    )
}