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
import com.app.parkingapp.viewModel.SharedUserViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController, sharedUserViewModel: SharedUserViewModel) {
    val viewModel: LoginViewModel = hiltViewModel()

    var cedula by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val errorMessage by viewModel.errorMessage.collectAsState()
    val loginSuccess by viewModel.loginSuccess.collectAsState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            val usuario = viewModel.userData.value
            println("🚀 Usuario logueado: $usuario")
            usuario?.let { sharedUserViewModel.setUser(it) }
            navController.navigate(NavRoutes.HomeScreen.route) {
                popUpTo(NavRoutes.Login.route) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_parking_amigo),
            contentDescription = "Logo Parking Amigo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Iniciar Sesión", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = cedula,
                onValueChange = { cedula = it },
                label = { Text("Cédula") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF5F3EF),
                    unfocusedContainerColor = Color(0xFFF5F3EF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF5F3EF),
                    unfocusedContainerColor = Color(0xFFF5F3EF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            )

            if (!errorMessage.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(errorMessage!!, color = Color.Red, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { scope.launch { viewModel.login(cedula, password) } },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9500)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text("Ingresar", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}