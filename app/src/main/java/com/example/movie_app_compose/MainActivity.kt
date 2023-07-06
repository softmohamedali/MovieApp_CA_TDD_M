package com.example.movie_app_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.core.data.connectivity.NetworkConnectivityObserver
import com.example.core.domain.connectivity.ConnectivityObserver
import com.example.movie_app_compose.navigation.SetupNavigation
import com.example.movie_app_compose.ui.theme.Movie_app_composeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var connectivityObserver: NetworkConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Movie_app_composeTheme {
                val scaffoldState=rememberScaffoldState()
                val navHostController= rememberNavController()
                val internetState by connectivityObserver.observer().collectAsState(initial =ConnectivityObserver.ConnectivityStatus.AVAILABLE )
                LaunchedEffect(key1 = internetState){
                    scaffoldState.snackbarHostState.showSnackbar("Internet is $internetState")
                }
                Scaffold(
                    scaffoldState =scaffoldState
                ) { padding ->
                    SetupNavigation(
                        modifier = Modifier.padding(padding),
                        navController = navHostController
                    )
                }

            }
        }

    }






}
