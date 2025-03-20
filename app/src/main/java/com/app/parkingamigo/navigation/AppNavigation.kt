package com.app.parkingamigo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.parkingamigo.welcome.compose.WelcomeScreen
import com.app.parkingamigo.login.compose.LoginScreen
import com.app.parkingamigo.pricing.compose.TarifasScreen
import com.app.parkingamigo.pricingDetail.compose.PantallaTarifas

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.Welcome.route) {
        composable(NavRoutes.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(NavRoutes.Login.route) {
            LoginScreen(navController)
        }
        composable(NavRoutes.pricing.route) {
            TarifasScreen(navController)
        }
        composable(NavRoutes.pricingDetail.route) {
            PantallaTarifas(navController)
        }
    }
}
