package com.joaoferreira.ine_data.repository

import android.util.Log
import com.joaoferreira.ine_data.local.IneDao
import com.joaoferreira.ine_data.remote.IneApi
import com.joaoferreira.ine_domain.model.Indicador
import com.joaoferreira.ine_domain.repository.IneRepository
import javax.inject.Inject

class IneRepositoryImpl @Inject constructor(
    private val api: IneApi,
    private val dao: IneDao
) : IneRepository {

    companion object {
        private const val TAG = "IneRepositoryImpl"
    }

    override suspend fun getIndicador(year: Int): Result<String> {
        return try {
            val indicadorIneDto = api.getIndicador(
                varcdCod = "0012748",
                dim1 = "S7A2021",
                dim2 = "PT,1",
                lang = "PT"
            )
            if (indicadorIneDto.isNotEmpty()) {
                val firstIndicadorIneDto = indicadorIneDto.first()
                //Result.success(firstIndicadorIneDto.data.get(year.toString()))
                Result.success("123")
            } else {
                Result.failure(Exception("Empty response"))
            }
        } catch (e: Exception) {
            Log.e(TAG, "getIndicador: ${e.message}")
            Result.failure(e)
        }
    }
}