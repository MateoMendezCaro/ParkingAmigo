package com.app.parkingapp.pricing.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.parkingamigo.domain.model.Tarifa
import com.app.parkingamigo.domain.usecases.GetTarifasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class VehiculoTipo { CARRO, MOTO, BICICLETA }

@HiltViewModel
class TarifasViewModel @Inject constructor(
    private val getTarifasUseCase: GetTarifasUseCase
) : ViewModel() {

    var tipoSeleccionado = mutableStateOf(VehiculoTipo.CARRO)
        private set

    var tarifasPorTipo = mutableStateOf<List<Tarifa>>(emptyList())
        private set

    fun cambiarTipo(tipo: VehiculoTipo) {
        tipoSeleccionado.value = tipo
        cargarTarifas()
    }

    init {
        cargarTarifas()
    }

    private fun cargarTarifas() {
        viewModelScope.launch {
            val todas = getTarifasUseCase.execute()
            tarifasPorTipo.value = todas.filter { it.tipo.equals(tipoSeleccionado.value.name, ignoreCase = true) }
        }
    }
}