package com.example.movie_app_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.domain.models.Screens
import com.example.presentation.home.HomeMovieScreen
import com.example.presentation.login.LoginScreen
import com.example.presentation.register.RegisterScreen


@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screens.Login.route)
    {
//        composable(route = Screens.Splash.route) {
//            SplashScreen(
//                navController = navController,
//                tokenManger = tokenManger
//            )
//        }

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
        composable(route = Screens.Home.route) {
            HomeMovieScreen(
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