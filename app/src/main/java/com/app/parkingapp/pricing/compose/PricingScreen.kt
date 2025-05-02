package com.app.parkingapp.pricing.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.parkingapp.R
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.pricing.viewmodel.TarifasViewModel
import com.app.parkingapp.pricing.viewmodel.VehiculoTipo

@Composable
fun TarifasScreen(
    navController: NavController,
    viewModel: TarifasViewModel = viewModel()
) {
    val tipoSeleccionado by viewModel.tipoSeleccionado

    ParkingScreen(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Text(text = "Tarifas", fontSize = 30.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                TipoTarifaBoton("Carro", VehiculoTipo.CARRO, tipoSeleccionado, viewModel)
                TipoTarifaBoton("Moto", VehiculoTipo.MOTO, tipoSeleccionado, viewModel)
                TipoTarifaBoton("Bicicleta", VehiculoTipo.BICICLETA, tipoSeleccionado, viewModel)
            }

            Spacer(modifier = Modifier.height(20.dp))

            ContenidoTarifa(tipoSeleccionado)
        }
    }
}

@Composable
fun TipoTarifaBoton(
    label: String,
    tipo: VehiculoTipo,
    tipoSeleccionado: VehiculoTipo,
    viewModel: TarifasViewModel,
    modifier: Modifier = Modifier
) {
    val colorFondo = if (tipoSeleccionado == tipo) Color(0xFFFFA500) else Color(0xFFEFEFEF)

    Button(
        onClick = { viewModel.cambiarTipo(tipo) },
        colors = ButtonDefaults.buttonColors(containerColor = colorFondo),
        modifier = modifier.height(40.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = label, color = Color.Black, fontSize = 18.sp)
    }
}

@Composable
fun ContenidoTarifa(tipo: VehiculoTipo) {
    val imagen = when (tipo) {
        VehiculoTipo.CARRO -> R.drawable.racingcar
        VehiculoTipo.MOTO -> R.drawable.motorbike
        VehiculoTipo.BICICLETA -> R.drawable.bicycle
    }

    Surface(
        color = Color(0xFFF7F7F7),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = "Icono Vehículo",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TarifaCard("Comunidad Amigoniana", "$4.000")
            Spacer(modifier = Modifier.height(8.dp))
            TarifaCard("Visitante Hora", "$4.000")
            Spacer(modifier = Modifier.height(8.dp))
            TarifaCard("Visitante Día", "$4.000")

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun TarifaCard(titulo: String, valor: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            color = Color(0xFF1E88A8), //
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = titulo,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.relojcircular),
                contentDescription = "Reloj",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Tarifa día", color = Color.Black, fontSize = 19.sp)
                Text(
                    text = valor,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

