package com.joaoferreira.ine_data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IndicadorIneDto(
    @Json(name = "IndicadorCod") val indicatorCode: String,
    @Json(name = "IndicadorDsg") val indicatorDescription: String,
    @Json(name = "MetaInfUrl") val metaInfoUrl: String,
    @Json(name = "DataExtracao") val extractionDate: String,
    @Json(name = "DataUltimoAtualizacao") val lastUpdateDate: String,
    @Json(name = "UltimoPref") val lastReferencePeriod: String,
    @Json(name = "Dados") val data: Map<String, List<Rendimentos>>,
    @Json(name = "Sucesso") val success: Map<String, List<SuccessMsg>>
)
