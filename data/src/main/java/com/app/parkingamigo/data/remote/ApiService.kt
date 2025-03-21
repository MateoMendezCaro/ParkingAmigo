package com.app.parkingamigo.data.remote

import com.app.parkingamigo.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body user: User): Response<LoginResponse>
}