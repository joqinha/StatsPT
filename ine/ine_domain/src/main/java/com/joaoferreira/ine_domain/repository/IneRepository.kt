package com.joaoferreira.ine_domain.repository

interface IneRepository {
    suspend fun getIndicador(year: Int): Result<String?>
}