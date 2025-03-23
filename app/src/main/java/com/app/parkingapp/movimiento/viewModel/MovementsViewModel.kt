package com.app.parkingapp.movimiento.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.parkingapp.movimiento.model.MovementItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MovimientosViewModel : ViewModel() {
    private val _movimientos = MutableStateFlow<List<MovementItem>>(emptyList())
    val movimientos: StateFlow<List<MovementItem>> = _movimientos

    private var currentPage = 0
    private val pageSize = 5

    private val allMovimientos = listOf(
        MovementItem(1, "Recarga desde Bancolombia", "13 Mar 2025", "10.000", "REF12345", "COM12345", "Celular"),
        MovementItem(2, "Recarga desde Davivienda", "13 Mar 2025", "15.000", "REF67890", "COM67890", "Tablet"),
        MovementItem(3, "Recarga desde Nequi", "13 Mar 2025", "8.000", "REF11111", "COM11111", "Celular"),
        MovementItem(4, "Recarga desde Bancolombia", "13 Mar 2025", "12.000", "REF22222", "COM22222", "Laptop"),
        MovementItem(5, "Recarga desde Davivienda", "13 Mar 2025", "11.000", "REF33333", "COM33333", "Celular"),
        MovementItem(6, "Recarga desde Nequi", "13 Mar 2025", "9.000", "REF44444", "COM44444", "Tablet"),
        MovementItem(7, "Recarga desde Bancolombia", "13 Mar 2025", "10.000", "REF12345", "COM12345", "Celular"),
        MovementItem(8, "Recarga desde Davivienda", "13 Mar 2025", "15.000", "REF67890", "COM67890", "Tablet"),
        MovementItem(9, "Recarga desde Nequi", "13 Mar 2025", "8.000", "REF11111", "COM11111", "Celular"),
        MovementItem(10, "Recarga desde Bancolombia", "13 Mar 2025", "12.000", "REF22222", "COM22222", "Laptop"),
        MovementItem(11, "Recarga desde Davivienda", "13 Mar 2025", "11.000", "REF33333", "COM33333", "Celular"),
        MovementItem(12, "Recarga desde Nequi", "13 Mar 2025", "9.000", "REF44444", "COM44444", "Tablet"),
        MovementItem(13, "Recarga desde Bancolombia", "13 Mar 2025", "10.000", "REF12345", "COM12345", "Celular"),
        MovementItem(14, "Recarga desde Davivienda", "13 Mar 2025", "15.000", "REF67890", "COM67890", "Tablet"),
        MovementItem(15, "Recarga desde Nequi", "13 Mar 2025", "8.000", "REF11111", "COM11111", "Celular"),
        MovementItem(16, "Recarga desde Bancolombia", "13 Mar 2025", "12.000", "REF22222", "COM22222", "Laptop"),
        MovementItem(17, "Recarga desde Davivienda", "13 Mar 2025", "11.000", "REF33333", "COM33333", "Celular"),
        MovementItem(18, "Recarga desde Nequi", "13 Mar 2025", "9.000", "REF44444", "COM44444", "Tablet"),
        MovementItem(19, "Recarga desde Bancolombia", "13 Mar 2025", "10.000", "REF12345", "COM12345", "Celular"),
        MovementItem(20, "Recarga desde Davivienda", "13 Mar 2025", "15.000", "REF67890", "COM67890", "Tablet"),
        MovementItem(21, "Recarga desde Nequi", "13 Mar 2025", "8.000", "REF11111", "COM11111", "Celular"),
        MovementItem(22, "Recarga desde Bancolombia", "13 Mar 2025", "12.000", "REF22222", "COM22222", "Laptop"),
        MovementItem(23, "Recarga desde Davivienda", "13 Mar 2025", "11.000", "REF33333", "COM33333", "Celular"),
        MovementItem(24, "Recarga desde Nequi", "13 Mar 2025", "9.000", "REF44444", "COM44444", "Tablet"),
    )

    init {
        loadMore()
    }

    fun loadMore() {
        val nextPage = allMovimientos.drop(currentPage * pageSize).take(pageSize)
        if (nextPage.isNotEmpty()) {
            _movimientos.value = _movimientos.value + nextPage
            currentPage++
        }
    }
}