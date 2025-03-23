package com.app.parkingapp.movimiento.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.movimiento.viewModel.MovimientosViewModel

@Composable
fun MovimientoDetalleScreen(
    navController: NavController,
    movimientoId: Int,
    viewModel: MovimientosViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val movimiento = viewModel.movimientos.collectAsState().value.find { it.id == movimientoId }

    ParkingScreen(navController) {
        movimiento?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f)
                        .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                        .background(Color(0xFFF5F3EF), RoundedCornerShape(12.dp))
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = it.fecha, fontSize = 16.sp, color = Color.Black)

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(text = it.descripcion, fontSize = 18.sp, color = Color.Black)

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "$ ${it.precio}",
                        fontSize = 26.sp,
                        color = Color(0xFF1A7895)
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(text = "descargar: ${it.comprobante}", fontSize = 16.sp, color = Color.Black)

                    Spacer(modifier = Modifier.height(38.dp))

                    Text(text = it.referencia, fontSize = 16.sp, color = Color.Black)

                    Spacer(modifier = Modifier.height(38.dp))

                    Text(text = it.dispositivo, fontSize = 16.sp, color = Color.Black)
                }
            }
        } ?: run {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Movimiento no encontrado",
                    color = Color.Red,
                    fontSize = 16.sp
                )
            }
        }
    }
}
