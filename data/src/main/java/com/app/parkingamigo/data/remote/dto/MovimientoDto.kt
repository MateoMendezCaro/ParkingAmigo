package com.app.parkingamigo.data.remote.dto

import com.app.parkingamigo.domain.model.Movimiento

data class MovimientoDto(
    val comprobante: String,
    val fecha: String,
    val monto: String,
    val origen: String,
    val referencia: String,
    val tarifaId: String,
    val userId: String
) {
    fun toDomain(): Movimiento = Movimiento(
        comprobante, fecha, monto, origen, referencia, tarifaId, userId
    )
}