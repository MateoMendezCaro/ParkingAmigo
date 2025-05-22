package com.app.parkingamigo.domain.model

data class Tarifa(
    val tipo: String,
    val hora: Int,
    val valor: Int,
    val amigoniano: Boolean
)