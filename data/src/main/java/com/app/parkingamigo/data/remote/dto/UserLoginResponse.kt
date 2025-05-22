package com.app.parkingamigo.data.remote.dto

import com.app.parkingamigo.domain.model.User

data class UserLoginResponse(
    val success: Boolean,
    val user: UserDto?
)

data class UserDto(
    val id: String,
    val nombre: String,
    val apellidos: String,
    val correo: String,
    val cedula: String
) {
    fun toDomain(): User = User(id, nombre, apellidos, correo, cedula)
}