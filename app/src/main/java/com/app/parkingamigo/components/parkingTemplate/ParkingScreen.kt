package com.app.parkingamigo.components.parkingTemplate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.parkingamigo.R

@Composable
fun ParkingScreen(navController: NavController, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_parking_amigo),
            contentDescription = "Logo Parking Amigo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(horizontal = 16.dp)
        ) {
            content()
        }

        com.app.parkingamigo.components.bottomNavigationBar.BottomNavigationBar(navController)
    }
}
