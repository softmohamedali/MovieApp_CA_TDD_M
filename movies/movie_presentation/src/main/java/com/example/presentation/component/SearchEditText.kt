package com.example.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.core.ui.BG_trans_light
import com.example.core.ui.Search_Back
import com.example.core.ui.Search_Text

@Composable
fun SearchEditText(
    label:String="Search A specific Movie",
    value:String="",
    readOnly:Boolean=false,
    enable:Boolean=false,
    onClick:()->Unit={},
    onTextChange:(String)->Unit={},
    myModifier: Modifier=if (readOnly) Modifier.clickable {
        onClick()
    } else{
        Modifier
    },

) {
    TextField(
        modifier=myModifier
            .clip(RoundedCornerShape(15.dp))
            .background(Search_Back)
            .clickable { onClick() },
        value = value,
        label = { Text(text = label)},
        onValueChange = {
            onTextChange(it)
        },
        textStyle = TextStyle(
            color = Search_Text
        ),
        leadingIcon = {
                      Icon(imageVector = Icons.Default.Search, contentDescription ="" )
        },
        readOnly=readOnly,
        enabled = enable,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor=BG_trans_light,
            focusedIndicatorColor=BG_trans_light,
            focusedLabelColor=BG_trans_light,
            disabledIndicatorColor=BG_trans_light,
            disabledLabelColor=BG_trans_light,
        )
    )
}