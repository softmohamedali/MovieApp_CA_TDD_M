package com.example.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
    value: String,
    label: String,
    onValueChange:(String)-> Unit,
    myModifier: Modifier=Modifier.fillMaxWidth(),
    isError:Boolean=false,
    error:String?=null,
    readOnly:Boolean=false,
    keybordoption:KeyboardOptions= KeyboardOptions.Default
){
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            modifier = myModifier.background(MaterialTheme.colors.background),
            value = value,
            singleLine = true,
            onValueChange = {
                onValueChange(it)
            },
            label = { Text(text = label)},
            isError =isError,
            keyboardOptions = keybordoption,
            readOnly = readOnly
        )
        if (isError){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = error?:"", color = MaterialTheme.colors.error)
        }
    }
}