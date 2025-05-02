package com.app.parkingapp.movimiento.model

data class MovementItem(
    val id: Int,
    val descripcion: String,
    val fecha: String,
    val precio: String,
    val referencia: String,
    val comprobante: String,
    val dispositivo: String
)
// borrar