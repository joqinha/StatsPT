package com.joaoferreira.ine_data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SuccessMsg(
    @Json(name = "Msg") val message: String
)
