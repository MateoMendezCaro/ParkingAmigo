package com.app.parkingamigo.data.remote.repository

import com.app.parkingamigo.data.remote.api.LoginApi
import com.app.parkingamigo.domain.model.User
import com.app.parkingamigo.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val api: LoginApi
) : LoginRepository {
    override suspend fun login(cedula: String, password: String): User? {
        val response = api.login(cedula, password)
        return if (response.success && response.user != null) {
            response.user.toDomain()
        } else {
            null
        }
    }
}
