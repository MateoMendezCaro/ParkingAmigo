package com.app.parkingamigo.navigation

sealed class NavRoutes(val route: String) {
    object Welcome : NavRoutes("welcome")
    object Login : NavRoutes("login")
    object pricing : NavRoutes("pricing")
    object pricingDetail : NavRoutes("pricingDetail")
}
