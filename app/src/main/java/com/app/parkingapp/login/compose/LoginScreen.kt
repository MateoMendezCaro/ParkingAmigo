package com.app.parkingapp.login.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.parkingapp.R
import com.app.parkingapp.login.viewmodel.LoginViewModel
import com.app.parkingapp.navigation.NavRoutes
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    // Obtengo la instancia de ViewModel con Hilt
    val viewModel: LoginViewModel = hiltViewModel()

    // Estados locales para campos de texto
    var cedula by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Estados expuestos por el ViewModel
    val errorMessage by viewModel.errorMessage.collectAsState()
    val loginSuccess by viewModel.loginSuccess.collectAsState()

    // Scope para lanzar coroutines desde la UI
    val scope = rememberCoroutineScope()

    // Efecto para navegar al Home cuando loginSuccess cambia a true
    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            navController.navigate(NavRoutes.HomeScreen.route) {
                popUpTo(NavRoutes.Login.route) { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Logo superior
        Image(
            painter = painterResource(id = R.drawable.logo_parking_amigo),
            contentDescription = "Logo Parking Amigo",
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Título
        Text(
            text = "Iniciar Sesión",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo Cédula
        TextField(
            value = cedula,
            onValueChange = { cedula = it },
            label = { Text("Cédula") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F3EF),
                unfocusedContainerColor = Color(0xFFF5F3EF),
                disabledContainerColor = Color(0xFFF5F3EF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Contraseña
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F3EF),
                unfocusedContainerColor = Color(0xFFF5F3EF),
                disabledContainerColor = Color(0xFFF5F3EF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        // Mensaje de error
        errorMessage?.takeIf { it.isNotEmpty() }?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = it,
                color = Color.Red,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de Ingresar
        Button(
            onClick = {
                scope.launch {
                    viewModel.login(cedula, password)
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9500)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp)
        ) {
            Text(
                text = "Ingresar",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}
