package com.app.parkingapp.profile.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.parkingapp.components.parkingTemplate.ParkingScreen
import com.app.parkingapp.navigation.NavRoutes
import com.app.parkingamigo.domain.model.User
import com.app.parkingapp.viewModel.SharedUserViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    sharedUserViewModel: SharedUserViewModel
) {
    val user by sharedUserViewModel.user.collectAsState()

    ParkingScreen(navController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFF7F7F7),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color(0xFFCCCCCC))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(120.dp)
                            .background(Color.White, shape = CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Foto de perfil",
                            tint = Color.Gray,
                            modifier = Modifier.size(100.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (user != null) {
                        Text(
                            text = "${user!!.nombre} ${user!!.apellidos}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = user!!.correo,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    } else {
                        CircularProgressIndicator()
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    ProfileButton("Cambiar contraseña", Icons.Default.Lock) { }

                    Spacer(modifier = Modifier.height(16.dp))

                    ProfileButton("Contáctanos", Icons.Default.Email) { }

                    Spacer(modifier = Modifier.height(16.dp))

                    ProfileButton("Cerrar sesión", Icons.Default.ExitToApp) {
                        sharedUserViewModel.clearUser()
                        navController.navigate(NavRoutes.Login.route) {
                            popUpTo(0)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileButton(text: String, icon: ImageVector, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFBBBBBB)),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = 15.sp,
                maxLines = 2,
                lineHeight = 20.sp
            )
        }
    }
}