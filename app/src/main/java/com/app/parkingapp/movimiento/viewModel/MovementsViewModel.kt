package com.app.parkingapp.movimiento.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.parkingamigo.domain.model.Movimiento
import com.app.parkingamigo.domain.usecases.GetMovimientosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovimientosViewModel @Inject constructor(
    private val getMovimientosUseCase: GetMovimientosUseCase
) : ViewModel() {

    private val _movimientos = MutableStateFlow<List<Movimiento>>(emptyList())
    val movimientos: StateFlow<List<Movimiento>> = _movimientos

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private var offset = 0
    private val pageSize = 5
    private var total = Int.MAX_VALUE

    init {
        loadMore()
    }

    fun loadMore() {
        if (_loading.value || offset >= total) return

        _loading.value = true
        viewModelScope.launch {
            try {
                val response = getMovimientosUseCase.execute(offset, pageSize)
                _movimientos.value = _movimientos.value + response.movimientos
                offset += pageSize
                total = response.total
            } finally {
                _loading.value = false
            }
        }
    }

    fun hasMoreMovimientos(): Boolean = offset < total

    fun getMovimientoByReferencia(ref: String): Movimiento? =
        _movimientos.value.find { it.referencia == ref }
}