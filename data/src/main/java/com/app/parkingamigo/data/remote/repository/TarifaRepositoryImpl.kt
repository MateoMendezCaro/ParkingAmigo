package com.app.parkingamigo.data.remote.repository


import com.app.parkingamigo.data.remote.api.TarifaApi
import com.app.parkingamigo.domain.model.Tarifa
import com.app.parkingamigo.domain.repository.TarifaRepository
import javax.inject.Inject

class TarifaRepositoryImpl @Inject constructor(
    private val api: TarifaApi
) : TarifaRepository {
    override suspend fun getTarifas(): List<Tarifa> {
        val response = api.getTarifas()
        return response.tarifas?.values?.map { it.toDomain() } ?: emptyList()
    }
}