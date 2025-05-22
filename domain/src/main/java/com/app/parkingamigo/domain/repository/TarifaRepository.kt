package com.app.parkingamigo.domain.repository

import com.app.parkingamigo.domain.model.Tarifa

interface TarifaRepository {
    suspend fun getTarifas(): List<Tarifa>
}