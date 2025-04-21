package com.app.parkingamigo.data.remote.api

import com.app.parkingamigo.data.remote.dto.UserLoginResponse
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Field

interface LoginApi {
    @FormUrlEncoded
    @POST("login.php")
    suspend fun login(
        @Field("cedula") cedula: String,
        @Field("password") password: String
    ): UserLoginResponse
}