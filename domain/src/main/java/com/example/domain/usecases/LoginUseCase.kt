package com.example.domain.usecases

import com.example.data.repository.UserRepository
class LoginUseCase(private val userRepository: UserRepository) {
    suspend fun login(cedula: String, password: String): Boolean {
        return userRepository.authenticate(cedula, password)
    }
}