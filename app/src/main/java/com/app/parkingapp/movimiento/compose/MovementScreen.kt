package com.app.parkingapp.movimiento.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import com.app.parkingapp.navigation.NavRoutes
import com.app.parkingamigo.domain.model.Movimiento

@Composable
fun MovimientosScreen(
    navController: NavController,
    viewModel: MovimientosViewModel = hiltViewModel()
) {
    val movimientos by viewModel.movimientos.collectAsState()
    val loading    by viewModel.loading.collectAsState()

    ParkingScreen(navController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Movimientos",
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                itemsIndexed(movimientos) { _, movimiento ->
                    MovimientoCard(movimiento) {
                        navController.navigate(
                            "${NavRoutes.MovementDetail.route}/${movimiento.referencia}"
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            when {
                loading -> {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
                viewModel.hasMoreMovimientos() -> {
                    Button(
                        onClick = { viewModel.loadMore() },
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .fillMaxWidth(0.8f)
                    ) {
                        Icon(Icons.Default.KeyboardArrowUp, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Cargar más movimientos")
                    }
                }
                else -> {
                    Text("No hay más movimientos", color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun MovimientoCard(
    movimiento: Movimiento,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .heightIn(min = 80.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F1EB)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = movimiento.origen,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = movimiento.fecha,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}
