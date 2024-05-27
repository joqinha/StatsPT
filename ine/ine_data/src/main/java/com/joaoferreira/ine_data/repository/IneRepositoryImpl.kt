package com.joaoferreira.ine_data.repository

import com.joaoferreira.ine_data.local.IneDao
import com.joaoferreira.ine_data.remote.IneApi
import com.joaoferreira.ine_domain.repository.IneRepository
import javax.inject.Inject

class IneRepositoryImpl @Inject constructor(
    private val api: IneApi,
    private val dao: IneDao
): IneRepository {
    override val test: Boolean
        get() = TODO("Not yet implemented")
}