package com.yonasoft.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    //Screens
    companion object {
        fun fromRoute(route:String?) : MovieScreens {
            return when (route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognised")
            }
        }
    }
}
