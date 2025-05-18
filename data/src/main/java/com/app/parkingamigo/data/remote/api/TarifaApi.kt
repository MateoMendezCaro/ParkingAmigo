package com.app.parkingamigo.data.remote.api

import com.app.parkingamigo.data.remote.dto.TarifasResponse
import retrofit2.http.GET

interface TarifaApi {
    @GET("getTarifas")
    suspend fun getTarifas(): TarifasResponse
}