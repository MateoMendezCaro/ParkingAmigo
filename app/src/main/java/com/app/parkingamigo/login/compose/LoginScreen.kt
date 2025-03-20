package com.app.parkingamigo.login.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.parkingamigo.login.viewmodel.LoginViewModel
import com.app.parkingamigo.navigation.NavRoutes
import com.app.parkingamigo.R
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    var cedula by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_parking_amigo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Iniciar Sesión",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de cédula
            OutlinedTextField(
                value = cedula,
                onValueChange = { cedula = it },
                placeholder = { Text(text = "Ingresar Cédula", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F3EF),
                    focusedContainerColor = Color(0xFFF5F3EF),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de contraseña
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Ingresar Contraseña", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F3EF),
                    focusedContainerColor = Color(0xFFF5F3EF),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de ingresar
            Button(
                onClick = {
                    navController.navigate(NavRoutes.pricing.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9500)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(48.dp)
            ) {
                Text(text = "Ingresar", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}
