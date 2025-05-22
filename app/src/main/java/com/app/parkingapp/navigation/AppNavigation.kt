package com.app.parkingapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.parkingapp.welcome.compose.WelcomeScreen
import com.app.parkingapp.login.compose.LoginScreen
import com.app.parkingapp.pricing.compose.TarifasScreen
import com.app.parkingapp.home.compose.HomeScreen
import com.app.parkingapp.movimiento.compose.MovimientoDetalleScreen
import com.app.parkingapp.movimiento.compose.MovimientosScreen
import com.app.parkingapp.movimiento.viewModel.MovimientosViewModel
import com.app.parkingapp.profile.compose.ProfileScreen
import com.app.parkingapp.viewModel.SharedUserViewModel
import com.app.parkingapp.recargas.compose.RecargaScreen
import androidx.compose.runtime.remember

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
        composable(NavRoutes.Recargas.route) {
            RecargaScreen(navController)
        }

        composable(
            route = "${NavRoutes.MovementDetail.route}/{movimientoId}",
            arguments = listOf(navArgument("movimientoId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val movimientoId = backStackEntry.arguments!!.getString("movimientoId")!!

            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(NavRoutes.Movement.route)
            }

            val vm: MovimientosViewModel = hiltViewModel(parentEntry)

            MovimientoDetalleScreen(
                navController   = navController,
                movimientoId    = movimientoId,
                viewModel       = vm
            )
        }
    }
}
