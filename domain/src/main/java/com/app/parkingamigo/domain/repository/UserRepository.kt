package com.app.parkingamigo.domain.repository

interface UserRepository {
    suspend fun authenticate(cedula: String, password: String): Boolean
}