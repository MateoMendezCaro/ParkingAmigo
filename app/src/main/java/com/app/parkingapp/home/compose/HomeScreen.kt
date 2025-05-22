package com.app.parkingapp.home.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.navigation.NavRoutes

@Composable
fun HomeScreen(navController: NavController) {
    ParkingScreen(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1) Card de Saldo: sólo wrapContentHeight, centrado
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F1EB))
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Saldo Disponible",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$ -- -- -- --",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF003366)
                    )
                }
            }

            // 2) Espacio fijo entre card y botones
            Spacer(modifier = Modifier.height(52.dp))

            // 3) Botones en columna, juntos y centrados
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StyledActionButton(
                    label = "Recargas",
                    onClick = { navController.navigate(NavRoutes.Recargas.route) }
                )
                Spacer(modifier = Modifier.height(22.dp))
                StyledActionButton(
                    label = "Movimientos",
                    onClick = { navController.navigate(NavRoutes.Movement.route) }
                )
            }
        }
    }
}

@Composable
private fun StyledActionButton(
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3F1EB)),
        contentPadding = PaddingValues(vertical = 0.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}
