package com.app.parkingapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.parkingapp.welcome.compose.WelcomeScreen
import com.app.parkingapp.login.compose.LoginScreen
import com.app.parkingapp.pricing.compose.TarifasScreen
import com.app.parkingapp.home.compose.HomeScreen
import com.app.parkingapp.movimiento.compose.MovimientoDetalleScreen
import com.app.parkingapp.movimiento.compose.MovimientosScreen
import com.app.parkingapp.profile.compose.ProfileScreen
import com.app.parkingapp.viewModel.SharedUserViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val sharedUserViewModel: SharedUserViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = NavRoutes.Welcome.route) {
        composable(NavRoutes.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(NavRoutes.Login.route) {
            LoginScreen(navController, sharedUserViewModel)
        }
        composable(NavRoutes.Pricing.route) {
            TarifasScreen(navController)
        }
        composable(NavRoutes.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(NavRoutes.Movement.route) {
            MovimientosScreen(navController)
        }
        composable(NavRoutes.Profile.route) {
            ProfileScreen(navController, sharedUserViewModel)
        }
        composable("${NavRoutes.MovementDetail.route}/{movimientoId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("movimientoId")?.toIntOrNull()
            if (id != null) {
                MovimientoDetalleScreen(navController, movimientoId = id)
            }
        }
    }
}
