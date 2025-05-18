package com.app.parkingamigo.data.remote.repository

import com.app.parkingamigo.data.remote.api.LoginApi
import com.app.parkingamigo.data.remote.api.LoginRequest
import com.app.parkingamigo.domain.model.User
import com.app.parkingamigo.domain.repository.LoginRepository
import java.io.IOException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: LoginApi
) : LoginRepository {
    override suspend fun login(cedula: String, password: String): User? {
        return try {
            val response = api.login(LoginRequest(cedula, password))
            response.user?.toDomain()
        } catch (e: IOException) {
            null
        }
    }
}
