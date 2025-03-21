package com.app.parkingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.parkingapp.navigation.NavRoutes
import com.app.parkingapp.welcome.compose.WelcomeScreen
import com.app.parkingapp.login.compose.LoginScreen
import com.app.parkingapp.pricing.compose.TarifasScreen
import com.app.parkingapp.pricingDetail.compose.PantallaTarifas

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
