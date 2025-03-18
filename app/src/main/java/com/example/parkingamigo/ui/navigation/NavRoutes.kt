package com.example.parkingamigo.ui.navigation

sealed class NavRoutes(val route: String) {
    object Welcome : NavRoutes("welcome")
    object Login : NavRoutes("login")
}
