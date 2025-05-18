package com.app.parkingamigo.data.remote.dto

import com.app.parkingamigo.domain.model.Tarifa

data class TarifasResponse(
    val success: Boolean,
    val tarifas: Map<String, TarifaDto>?
)

data class TarifaDto(
    val tipo: String,
    val hora: Int,
    val valor: Int,
    val amigoniano: Boolean
) {
    fun toDomain(): Tarifa = Tarifa(tipo, hora, valor, amigoniano)
}