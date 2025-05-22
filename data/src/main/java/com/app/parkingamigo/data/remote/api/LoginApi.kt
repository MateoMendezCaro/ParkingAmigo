package com.app.parkingamigo.data.remote.api
import com.app.parkingamigo.data.remote.dto.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class LoginRequest(val cedula: String, val contraseña: String)

interface LoginApi {
    @Headers("Content-Type: application/json")
    @POST("login")
    suspend fun login(@Body request: LoginRequest): UserLoginResponse
}