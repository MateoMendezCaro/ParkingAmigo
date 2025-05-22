package com.app.parkingamigo.data.remote.dto

data class MovimientoListResponse(
    val success: Boolean,
    val movimientos: List<MovimientoDto>,
    val total: Int
)