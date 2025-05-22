package com.app.parkingamigo.domain.usecases

import com.app.parkingamigo.domain.model.Tarifa
import com.app.parkingamigo.domain.repository.TarifaRepository

class GetTarifasUseCase(private val repo: TarifaRepository) {
    suspend fun execute(): List<Tarifa> = repo.getTarifas()
}
