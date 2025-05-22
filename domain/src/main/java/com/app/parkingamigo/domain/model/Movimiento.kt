package com.app.parkingamigo.domain.model

data class Movimiento(
    val comprobante: String,
    val fecha: String,
    val monto: String,
    val origen: String,
    val referencia: String,
    val tarifaId: String,
    val userId: String
)