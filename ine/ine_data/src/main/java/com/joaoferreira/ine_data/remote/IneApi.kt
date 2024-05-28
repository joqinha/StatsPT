package com.joaoferreira.ine_data.remote

import com.joaoferreira.ine_data.remote.dto.IndicadorIneDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IneApi {
    @GET("ine/json_indicador/pindica.jsp")
    suspend fun getIndicador(
        @Query("op") op: String = "2",
        @Query("varcd") varcdCod: String,
        @Query("Dim1") dim1: String,
        @Query("Dim2") dim2: String,
        @Query("lang") lang: String
    ): List<IndicadorIneDto>

    companion object {
        const val BASE_URL = "https://www.ine.pt/"
    }
}