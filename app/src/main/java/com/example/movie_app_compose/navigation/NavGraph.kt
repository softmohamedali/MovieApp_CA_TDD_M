package com.example.movie_app_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.domain.models.Screens
import com.example.presentation.main.MainScreen
import com.example.presentation.login.LoginScreen
import com.example.presentation.register.RegisterScreen
import com.example.presentation.splash.SplashScreen


@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screens.Splash.route)
    {
        composable(route = Screens.Splash.route) {
            SplashScreen(
                navHostController = navController,
            )
        }
        composable(
            route = Screens.Login.route,
        ) {
            LoginScreen(
                navHostController = navController,
            )
        }
        composable(
            route = Screens.Register.route,
        ) {
            RegisterScreen(
                navHostController = navController,
            )
        }
        composable(route = Screens.Main.route) {
            MainScreen(
                navHostController = navController,
            )
        }
    }
}

















//
//composable(
//route = Screens.Register.route,
//arguments = arrayListOf(
//navArgument(Constants.USER_TYPE) {
//    type = NavType.StringType
//}
//)
//) {
//    val userType = it.arguments!!.getString(Constants.USER_TYPE)
//    RegisterOwnerScreen(
//        navController = navController,
//        userType = userType!!,
//    )
//}