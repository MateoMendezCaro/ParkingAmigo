package com.app.parkingapp.navigation

sealed class NavRoutes(val route: String) {
    object Welcome : NavRoutes("welcome")
    object Login : NavRoutes("login")
    object Pricing : NavRoutes("pricing")
    object HomeScreen : NavRoutes("HomeScreen")
    object Movement : NavRoutes("Movement")
    object MovementDetail : NavRoutes("MovementDetail")
    object Profile : NavRoutes("profile")
}
