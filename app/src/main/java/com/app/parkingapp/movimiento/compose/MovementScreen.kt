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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.movimiento.model.MovementItem
import com.app.parkingapp.movimiento.viewModel.MovimientosViewModel
import com.app.parkingapp.navigation.NavRoutes

@Composable
fun MovimientosScreen(navController: NavController) {
    val viewModel: MovimientosViewModel = viewModel()
    val movimientos by viewModel.movimientos.collectAsState()

    ParkingScreen(navController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Movimientos",
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                itemsIndexed(movimientos) { index, movimiento ->
                    MovimientoCard(movimiento) {
                        navController.navigate("${NavRoutes.MovementDetail.route}/${movimiento.id}")
                    }

                    if (index == movimientos.lastIndex && movimientos.size < 24) {
                        LaunchedEffect(Unit) {
                            viewModel.loadMore()
                        }
                    }
                }
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Cargar más",
                modifier = Modifier.padding(6.dp)
            )
            Text("Cargar movimientos", modifier = Modifier.padding(bottom = 6.dp))
        }
    }
}


@Composable
fun MovimientoCard(movimiento: MovementItem, onClick: () -> Unit) {
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
                text = movimiento.descripcion,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp)
            )

            Text(
                text = movimiento.fecha,
                fontSize = 14.sp,
                color = Color.Black,
                maxLines = 1
            )
        }
    }
}
