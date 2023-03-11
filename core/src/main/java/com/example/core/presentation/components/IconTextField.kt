package com.example.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun IconTextField(
    value: String = "",
    label: String,
    onValueChange: (String) -> Unit,
    myModifier: Modifier = Modifier.fillMaxWidth(),
    icon: Int,
    onClick:()->Unit={},
    onIconClick:()->Unit={},
    readOnly:Boolean=false,
    isError:Boolean=false,
    error:String?=null,
    keyboardType:KeyboardType=KeyboardType.Text,
    secoundIcon:Int?=null,
    onSecoundIconClick:()->Unit={}
) {
    Column(
        modifier = myModifier.clickable { onClick() }
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            readOnly = readOnly,
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.onSecondary),
            singleLine = true,
            label = { Text(text = label) },
            textStyle = TextStyle(color = Color.DarkGray),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            leadingIcon = {
                IconButton(
                    onClick = {onIconClick() },
                    content = {Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "Search"
                    )}
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {onSecoundIconClick() },
                    content = {
                        if (secoundIcon!=null){
                            Icon(
                                painter = painterResource(id = secoundIcon),
                                contentDescription = "Search",

                            )
                        }
                    }
                )
            },
            isError = isError
        )
        if (isError){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = error?:"", color = MaterialTheme.colors.error)
        }
    }
}



