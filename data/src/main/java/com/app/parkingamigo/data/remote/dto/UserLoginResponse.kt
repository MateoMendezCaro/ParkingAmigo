package com.app.parkingamigo.data.remote.dto

import com.app.parkingamigo.domain.model.User

data class UserLoginResponse(
    val success: Boolean,
    val user: UserDto?
)

data class UserDto(
    val cedula: String
) {
    fun toDomain(): User = User(cedula)
}