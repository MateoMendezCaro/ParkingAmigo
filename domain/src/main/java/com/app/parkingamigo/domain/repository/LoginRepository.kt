package com.app.parkingamigo.domain.repository

import com.app.parkingamigo.domain.model.User


interface LoginRepository {
    suspend fun login(cedula: String, password: String): User?
}