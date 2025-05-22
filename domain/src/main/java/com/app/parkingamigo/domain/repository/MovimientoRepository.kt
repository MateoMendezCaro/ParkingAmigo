package com.app.parkingamigo.domain.repository
import com.app.parkingamigo.domain.model.MovimientoResponse

interface MovimientoRepository {
    suspend fun getMovimientos(offset: Int, limit: Int): MovimientoResponse
}