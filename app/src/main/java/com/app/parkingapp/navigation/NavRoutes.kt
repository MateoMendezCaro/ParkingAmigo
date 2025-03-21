package com.app.parkingapp.navigation

sealed class NavRoutes(val route: String) {
    object Welcome : NavRoutes("welcome")
    object Login : NavRoutes("login")
    object pricing : NavRoutes("pricing")
    object pricingDetail : NavRoutes("pricingDetail")
}
