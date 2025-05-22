package com.app.parkingamigo.domain.model


data class User(
    val id: String,
    val nombre: String,
    val apellidos: String,
    val correo: String,
    val cedula: String
)