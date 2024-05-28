package com.joaoferreira.ine_data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rendimentos(
    @Json(name = "geocod") val geoCode: String,
    @Json(name = "geodsg") val geoDescription: String,
    @Json(name = "ind_string") val indicatorStringValue: String,
    @Json(name = "valor") val value: String
)
