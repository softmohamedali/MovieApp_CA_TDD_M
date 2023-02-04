package com.example.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.ui.BG_trans_light
import com.example.core.ui.CimaTextStyle.normalText
import com.example.core.ui.CimaTextStyle.smallTextBold
import com.example.core.ui.Title200
import com.example.core.ui.White
import com.example.domin.models.GenreMovie


@Composable
fun TypeMovieList(
    types:List<GenreMovie>,
    name:String,
){

    Row (
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "$name : ",
            style = normalText,
            color = Title200
        )
        LazyVerticalGrid(
            userScrollEnabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(((types.size/3)*40).dp)
            ,
            columns = GridCells.Fixed(3),
            content ={
                items(types.size){
                    Text(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(BG_trans_light)
                            .padding(vertical = 5.dp, horizontal = 10.dp)

                        ,
                        text =types[it].name,
                        color = White,
                        style = smallTextBold,
                        textAlign = TextAlign.Center
                    )
                }

            }
        )

    }
}