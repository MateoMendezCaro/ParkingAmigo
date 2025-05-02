package com.app.parkingapp.pricing.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
                .padding(start = 12.dp, end = 12.dp, bottom = 8.dp), // menos bottom
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tarifas",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                TipoBoton("Carro", tipoSeleccionado == VehiculoTipo.CARRO) { viewModel.cambiarTipo(VehiculoTipo.CARRO) }
                TipoBoton("Moto", tipoSeleccionado == VehiculoTipo.MOTO) { viewModel.cambiarTipo(VehiculoTipo.MOTO) }
                TipoBoton("Bicicleta", tipoSeleccionado == VehiculoTipo.BICICLETA) { viewModel.cambiarTipo(VehiculoTipo.BICICLETA) }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Ya no usamos weight(1f); la card se ajusta a su contenido
            ContenidoTarifa(
                tipo = tipoSeleccionado,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
        }
    }
}

@Composable
private fun TipoBoton(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.height(36.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color(0xFFFFA500) else Color(0xFFEFEFEF)
        )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Composable
private fun ContenidoTarifa(
    tipo: VehiculoTipo,
    modifier: Modifier = Modifier
) {
    val imagen = when (tipo) {
        VehiculoTipo.CARRO     -> R.drawable.racingcar
        VehiculoTipo.MOTO      -> R.drawable.motorbike
        VehiculoTipo.BICICLETA -> R.drawable.bicycle
    }

    Surface(
        modifier = modifier,
        color = Color(0xFFF7F7F7),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                modifier = Modifier.size(75.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TarifaCard("Comunidad Amigoniana", "$4.000")
            Spacer(modifier = Modifier.height(12.dp))
            TarifaCard("Visitante Hora", "$4.000")
            Spacer(modifier = Modifier.height(12.dp))
            TarifaCard("Visitante Día", "$4.000")

            Spacer(modifier = Modifier.height(20.dp))

            // Botón sin altura fija, con padding interno
            Button(
                onClick = { /* acción de recargar */ },
                modifier = Modifier.fillMaxWidth(0.6f),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500)),
                contentPadding = PaddingValues(vertical = 12.dp) // ajusta altura al contenido
            ) {
                Text(
                    text = "Recargar",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
private fun TarifaCard(titulo: String, valor: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            color = Color(0xFF1E88A8),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .wrapContentWidth()
                .height(32.dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.relojcircular),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Tarifa día",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp
                )
                Text(
                    text = valor,
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}
