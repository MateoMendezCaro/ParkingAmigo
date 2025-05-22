package com.app.parkingamigo.domain.model

data class MovimientoResponse(
    val movimientos: List<Movimiento>,
    val total: Int
)