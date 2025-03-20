package com.app.parkingamigo.components.bottomNavigationBar

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.parkingamigo.navigation.NavRoutes

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 8.dp
    ) {
        val items = listOf(
            BottomNavItem("Principal", Icons.Default.Home, NavRoutes.pricing.route),
            BottomNavItem("Tarifas", Icons.Default.Info, NavRoutes.pricing.route),
            BottomNavItem("Perfil", Icons.Default.AccountCircle, NavRoutes.pricing.route)
        )

        var selectedItem by remember { mutableStateOf(NavRoutes.pricingDetail.route) }

        items.forEach { item ->
            NavigationBarItem(
                selected = selectedItem == item.route,
                onClick = {
                    selectedItem = item.route
                    navController.navigate(item.route)
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

data class BottomNavItem(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val route: String)
