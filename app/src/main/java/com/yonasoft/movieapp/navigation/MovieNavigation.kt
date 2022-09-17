package com.yonasoft.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yonasoft.movieapp.screens.details.DetailsScreen
import com.yonasoft.movieapp.screens.home.HomeScreen

//Navigation component
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(
            //Pass movie data to detail screen
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) {
            backStackEntry ->
            DetailsScreen(navController = navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}

