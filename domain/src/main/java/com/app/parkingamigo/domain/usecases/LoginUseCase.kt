package com.app.parkingamigo.domain.usecases

import com.app.parkingamigo.domain.model.User
import com.app.parkingamigo.domain.repository.LoginRepository

class LoginUseCase(
    private val repository: LoginRepository
) {
    suspend fun login(cedula: String, password: String): User? =
        repository.login(cedula, password)
}
