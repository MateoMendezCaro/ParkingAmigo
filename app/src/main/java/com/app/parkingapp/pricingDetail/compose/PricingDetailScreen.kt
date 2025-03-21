package com.app.parkingapp.pricingDetail.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.parkingapp.R
import com.app.parkingapp.components.parkingTemplate.ParkingScreen

data class TarifaItem(val titulo: String, val valor: String)

@Composable
fun PantallaTarifas(navController: NavController) {
    val tarifas = listOf(
        TarifaItem("Tarifa día", "$4.000"),
        TarifaItem("Primera 5 horas", "$4.000"),
        TarifaItem("Tarifa mensual", "$20.200")
    )

    ParkingScreen(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            Spacer(modifier = Modifier.height(24.dp))
            TarifaList(tarifas)
        }
    }
}

@Composable
fun Header() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.racingcar),
            contentDescription = "Vehículo",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Comunidad Amigoniana",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun TarifaList(tarifas: List<TarifaItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(tarifas) { tarifa ->
            ItemTarifa(tarifa)
        }
    }
}

@Composable
fun ItemTarifa(tarifaItem: TarifaItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.relojcircular),
            contentDescription = "Icono reloj",
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = tarifaItem.titulo, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = tarifaItem.valor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}
