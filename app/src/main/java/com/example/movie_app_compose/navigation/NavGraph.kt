package com.example.movie_app_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.core.domain.models.Screens
import com.example.presentation.details.actors_details.DetailsActorScreen
import com.example.presentation.details.movie_detals.MovieDetailsScreen
import com.example.presentation.details.series_details.DetailsSeriesScreen
import com.example.presentation.main.MainScreen
import com.example.presentation.login.LoginScreen
import com.example.presentation.register.RegisterScreen
import com.example.presentation.search.SearchScreen
import com.example.presentation.splash.SplashScreen


@Composable
fun SetupNavigation(
    modifier: Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = Screens.Splash.route
    ) {
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
        composable(
            route = Screens.MovieDetails.route,
            arguments = listOf(
                navArgument("id"){
                    type= NavType.IntType
                }
            )
        ) {
            val movie_Id=it.arguments!!.getInt("id")
            MovieDetailsScreen(
                navHostController = navController,
                movie_Id
            )
        }
        composable(
            route = Screens.SeriesDetails.route,
            arguments = listOf(
                navArgument("id"){
                    type= NavType.IntType
                }
            )
        ) {
            val movie_Id=it.arguments!!.getInt("id")
            DetailsSeriesScreen(
                navHostController = navController,
                movie_Id
            )
        }
        composable(
            route = Screens.ActorDetails.route,
            arguments = listOf(
                navArgument("id"){
                    type= NavType.IntType
                }
            )
        ) {
            val movie_Id=it.arguments!!.getInt("id")
            DetailsActorScreen(
                navHostController = navController,
                movie_Id
            )
        }

        composable(
            route = Screens.Search.route,
        ) {
            SearchScreen(
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