package com.example.core.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MyCheakBoxValidate(
    value:Boolean,
    isError:Boolean=false,
    error:String?=null,
    onCheakedChange:(Boolean)-> Unit,
    modifier: Modifier=Modifier.fillMaxWidth()
){
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked =value, onCheckedChange ={onCheakedChange(it)} )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text ="I Read and accepte Privace and Terms")
        }
        if (isError){
            Text(
                text = error?:"",
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}