package com.app.parkingamigo.data.remote.repository
import com.app.parkingamigo.data.remote.api.MovimientoApi
import com.app.parkingamigo.domain.model.MovimientoResponse
import com.app.parkingamigo.domain.repository.MovimientoRepository
import javax.inject.Inject

class MovimientoRepositoryImpl @Inject constructor(
    private val api: MovimientoApi
) : MovimientoRepository {
    override suspend fun getMovimientos(offset: Int, limit: Int): MovimientoResponse {
        val response = api.getMovimientos(offset, limit)
        return MovimientoResponse(
            movimientos = response.movimientos.map { it.toDomain() },
            total = response.total
        )
    }
}