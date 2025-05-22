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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.movimiento.viewModel.MovimientosViewModel

@Composable
fun MovimientoDetalleScreen(
    navController: NavController,
    movimientoId: String,
    viewModel: MovimientosViewModel
) {
    val movimiento = viewModel.getMovimientoByReferencia(movimientoId)

    ParkingScreen(navController) {
        movimiento?.let {
            Column(
                modifier = Modifier.fillMaxSize(),
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Fecha: ${it.fecha}", fontSize = 16.sp)
                    Spacer(Modifier.height(20.dp))
                    Text("Origen: ${it.origen}", fontSize = 18.sp)
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "Monto: $${it.monto}",
                        fontSize = 26.sp,
                        color = Color(0xFF1A7895)
                    )
                    Spacer(Modifier.height(20.dp))
                    Text("Comprobante: ${it.comprobante}", fontSize = 16.sp)
                    Spacer(Modifier.height(20.dp))
                    Text("Referencia: ${it.referencia}", fontSize = 16.sp)
                    Spacer(Modifier.height(20.dp))
                    Text("Tarifa: ${it.tarifaId}", fontSize = 16.sp)
                }
            }
        } ?: Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Movimiento no encontrado", color = Color.Red)
        }
    }
}