package com.app.parkingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.parkingapp.welcome.compose.WelcomeScreen
import com.app.parkingapp.login.compose.LoginScreen
import com.app.parkingapp.pricing.compose.TarifasScreen
import com.app.parkingapp.pricingDetail.compose.PantallaTarifas
import com.app.parkingapp.home.compose.HomeScreen
import com.app.parkingapp.movimiento.compose.MovimientoDetalleScreen
import com.app.parkingapp.movimiento.compose.MovimientosScreen

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
        composable(NavRoutes.Pricing.route) {
            TarifasScreen(navController)
        }
        composable(NavRoutes.PricingDetail.route) {
            PantallaTarifas(navController)
        }
        composable(NavRoutes.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(NavRoutes.Movement.route) {
            MovimientosScreen(navController)
        }
        composable("${NavRoutes.MovementDetail.route}/{movimientoId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("movimientoId")?.toIntOrNull()
            if (id != null) {
                MovimientoDetalleScreen(navController, movimientoId = id)
            }
        }
    }
}
