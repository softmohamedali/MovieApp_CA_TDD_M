package com.example.presentation.register.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.core.presentation.LoadingLayer
import com.example.core.presentation.MyCheakBoxValidate
import com.example.presentation.components.MySolidButton
import com.example.presentation.components.MyTextField
import com.example.presentation.components.PasswordTextField
import kotlinx.coroutines.launch

@Composable
fun RegisterView(
    email:String,
    emailError:String?=null,
    password:String,
    passwordError:String?=null,
    name:String,
    nameError:String?=null,
    confirmPass:String,
    confirmPasswordError:String?=null,
    termsChecked:Boolean,
    termsError:String?=null,
    isLoading:Boolean,
    isSuccess:Boolean,
    isError: String?,
    onEmailChange:(String)-> Unit,
    onPasswordChange:(String)-> Unit,
    onNameChange:(String)-> Unit,
    onConfirmPassChange:(String)-> Unit,
    onTermsChange:(Boolean)->Unit,
    onRegisterClick:()->Unit,
){

    val scaffoldState = rememberScaffoldState()
    //TODO what the diff betw this and remmber courtine scope
    val scope= LocalLifecycleOwner.current.lifecycleScope
    LaunchedEffect(key1 = isError ){
        if (isError!=null){
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Error:$isError","OK")
            }
        }
    }
    LaunchedEffect(key1 = isSuccess){
        if (isSuccess){
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "successfully Register"
                )
            }
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(enabled = !isLoading, onClick = { })
                ,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Register",style = TextStyle(
                        color = Color.Black,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    MyTextField(
                        value =email,
                        label ="Enter Email",
                        onValueChange = {
                            onEmailChange(it)
                        },
                        isError = emailError!=null,
                        error = emailError,
                        keybordoption = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    MyTextField(
                        value =name,
                        label ="Enter Your Name",
                        onValueChange = {
                            onNameChange(it)
                        },
                        isError = nameError!=null,
                        error = nameError
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Spacer(modifier = Modifier.height(5.dp))
                    PasswordTextField(
                        value =password,
                        label ="Enter Password",
                        onValueChange = {
                            onPasswordChange(it)
                        },
                        isError = passwordError!=null,
                        error = passwordError
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    PasswordTextField(
                        value =confirmPass,
                        label ="Confirm Password",
                        onValueChange = {
                            onConfirmPassChange(it)
                        },
                        isError = confirmPasswordError!=null,
                        error = confirmPasswordError
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    MyCheakBoxValidate(
                        isError = termsError!=null,
                        error = termsError,
                        value = termsChecked,
                        onCheakedChange = {onTermsChange(it)}
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    MySolidButton(
                        text = "Register",
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        onRegisterClick()
                    }
                }
                if (isLoading){
                    LoadingLayer()
                }
            }
        })


}