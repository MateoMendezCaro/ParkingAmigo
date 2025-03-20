package com.app.parkingamigo.pricing.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

enum class VehiculoTipo { CARRO, MOTO, BICICLETA }

class TarifasViewModel : ViewModel() {
    var tipoSeleccionado = mutableStateOf(VehiculoTipo.CARRO)
        private set

    fun cambiarTipo(tipo: VehiculoTipo) {
        tipoSeleccionado.value = tipo
    }
}
