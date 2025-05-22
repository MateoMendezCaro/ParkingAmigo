package com.app.parkingamigo.domain.usecases


import com.app.parkingamigo.domain.model.MovimientoResponse
import com.app.parkingamigo.domain.repository.MovimientoRepository

class GetMovimientosUseCase(
    private val repository: MovimientoRepository
) {
    suspend fun execute(offset: Int, limit: Int): MovimientoResponse =
        repository.getMovimientos(offset, limit)
}