package com.app.parkingapp.recargas.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.parkingapp.R
import com.app.parkingapp.components.parkingTemplate.ParkingScreen

@Composable
fun RecargaScreen(
    navController: NavController,
) {
    var saldo by remember { mutableStateOf("-- --- --- --") }

    ParkingScreen(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 64.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Caja de saldo disponible
            SaldoDisponibleBox(saldo = saldo)
            Spacer(modifier = Modifier.height(100.dp))
            // Texto "Realizar pago por:"
            Text(
                text = "Realizar pago por:",
                fontSize = 23.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de PSE
            Image(
                painter = painterResource(id = R.drawable.pse_button),
                contentDescription = "Botón PSE",
                modifier = Modifier
                    .width(520.dp)
                    .height(100.dp)

            )
        }
    }
}

@Composable
private fun SaldoDisponibleBox(saldo: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F3EF), shape = RoundedCornerShape(22.dp))
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Saldo Disponible",
            fontSize = 25.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$",
                fontSize = 28.sp,
                color = Color(0xFF345F80)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = saldo,
                fontSize = 28.sp,
                color = Color(0xFF345F80)
            )
        }
    }
}