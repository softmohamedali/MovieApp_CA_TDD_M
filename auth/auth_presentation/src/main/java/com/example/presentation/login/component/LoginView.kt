package com.example.presentation.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.presentation.LoadingLayer
import com.example.core.ui.Main_Color
import com.example.presentation.components.MySolidButton
import com.example.presentation.components.MyTextField
import com.example.presentation.components.PasswordTextField
import kotlinx.coroutines.launch

@Composable
fun LoginView(
    email:String,
    isEmailError:Boolean,
    emailError:String?,
    password:String,
    isPasswordError:Boolean,
    passwordError:String?,
    isLoading:Boolean,
    isSuccess:Boolean,
    isError: String?,
    onEmailChange:(String)-> Unit,
    onPasswordChange:(String)-> Unit,
    onLoginClick:()->Unit,
    onRegisterClick:()->Unit,
) {
    val stateScrollable= rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    val scope= rememberCoroutineScope()
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
                    message = "successfully Login"
                )
            }
        }
    }
    Scaffold(
        modifier = Modifier.background(Main_Color),
        scaffoldState = scaffoldState,
        content = {
            Box(modifier = Modifier.fillMaxSize()){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(stateScrollable)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                ) {

                    Text(text = "Log In",style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                    )
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    MyTextField(
                        value =email,
                        label ="Enter your Email",
                        onValueChange = {
                            onEmailChange(it)
                        },
                        isError = isEmailError,
                        error = emailError,
                        keybordoption = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    PasswordTextField(
                        value =password,
                        label ="Enter Your Password",
                        onValueChange = {
                            onPasswordChange(it)
                        },
                        isError = isPasswordError,
                        error = passwordError
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    MySolidButton(
                        text = "Log In",
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        onLoginClick()
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Dont Have email ? ",
                            fontSize = 15.sp
                        )
                        ClickableText(
                            text = AnnotatedString("Register"),
                            style = TextStyle(
                                fontSize = 15.sp,
                                color = Main_Color,
                            ),
                            onClick ={
                                onRegisterClick()
                            }
                        )
                    }

                }
                if (isLoading){
                    LoadingLayer()
                }

            }
        }
    )
}