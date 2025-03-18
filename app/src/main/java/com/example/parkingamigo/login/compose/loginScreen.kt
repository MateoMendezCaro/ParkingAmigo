package com.example.parkingamigo.login.compose

import androidx.compose.foundation.Image
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
import com.example.parkingamigo.R

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Iniciar Sesión",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Ingresar Cédula", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFF7F4F1),
                focusedContainerColor = Color(0xFFF7F4F1),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Ingresar Contraseña", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFF7F4F1),
                focusedContainerColor = Color(0xFFF7F4F1),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Ingresar", color = Color.White, fontSize = 16.sp)
        }
    }
}
