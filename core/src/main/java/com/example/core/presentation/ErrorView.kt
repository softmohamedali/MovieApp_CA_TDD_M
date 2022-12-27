package com.example.core.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.domain.utils.UiText
import com.example.core.ui.ErrorTint
import com.example.core.ui.White
import com.example.core.ui.textBold1

@Composable
fun ErrorView (
    errorText:String,
){
    val scrollState= rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp).verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,

    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier=Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription =errorText,
                tint = ErrorTint
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text =errorText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = textBold1,
                color = White
            )
        }

    }
}