package com.app.parkingamigo.data.remote.api

import com.app.parkingamigo.data.remote.dto.MovimientoListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovimientoApi {
    @GET("getMovimientos")
    suspend fun getMovimientos(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): MovimientoListResponse
}