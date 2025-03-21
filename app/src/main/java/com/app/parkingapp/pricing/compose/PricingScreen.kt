package com.app.parkingapp.pricing.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.parkingapp.navigation.NavRoutes
import com.app.parkingapp.pricing.viewmodel.TarifasViewModel
import com.app.parkingapp.pricing.viewmodel.VehiculoTipo
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.R

@Composable
fun TarifasScreen(navController: NavController, viewModel: TarifasViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val tipoSeleccionado by viewModel.tipoSeleccionado

    ParkingScreen(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "Tarifas", fontSize = 20.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                TipoTarifaBoton("Carro", VehiculoTipo.CARRO, tipoSeleccionado, viewModel)
                TipoTarifaBoton("Moto", VehiculoTipo.MOTO, tipoSeleccionado, viewModel)
                TipoTarifaBoton("Bicicleta", VehiculoTipo.BICICLETA, tipoSeleccionado, viewModel)
            }

            Spacer(modifier = Modifier.height(16.dp))

            ContenidoTarifa(tipoSeleccionado, navController)
        }
    }
}

@Composable
fun TipoTarifaBoton(label: String, tipo: VehiculoTipo, tipoSeleccionado: VehiculoTipo, viewModel: TarifasViewModel, modifier: Modifier = Modifier) {
    val colorFondo = if (tipoSeleccionado == tipo) Color(0xFFFFA500) else Color(0xFFEFEFEF)

    Button(
        onClick = { viewModel.cambiarTipo(tipo) },
        colors = ButtonDefaults.buttonColors(containerColor = colorFondo),
        modifier = modifier.height(40.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = label, color = Color.Black, fontSize = 14.sp)
    }
}

@Composable
fun ContenidoTarifa(tipo: VehiculoTipo, navController: NavController) {
    val imagen = when (tipo) {
        VehiculoTipo.CARRO -> R.drawable.racingcar
        VehiculoTipo.MOTO -> R.drawable.motorbike
        VehiculoTipo.BICICLETA -> R.drawable.bicycle
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "Icono Vehículo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(NavRoutes.pricingDetail.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0)),
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Comunidad Amigoniana", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate(NavRoutes.pricingDetail.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0)),
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Visitante", color = Color.White)
        }
    }
}
