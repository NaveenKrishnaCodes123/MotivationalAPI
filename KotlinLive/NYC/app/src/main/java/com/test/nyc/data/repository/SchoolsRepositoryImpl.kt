
package com.test.nyc.data.repository

import com.test.nyc.data.model.toDomain
import com.test.nyc.data.remote.ApiService
import com.test.nyc.domain.model.SatScore
import com.test.nyc.domain.model.School
import com.test.nyc.domain.repository.SchoolsRepository
import javax.inject.Inject

class SchoolsRepositoryImpl @Inject constructor(
    private val api: ApiService
) : SchoolsRepository {
    override suspend fun getSchools(limit: Int, offset: Int, query: String?): List<School> {
        val list = api.getSchools(limit, offset, query)
        return list.map { it.toDomain() }
    }

    override suspend fun getSatForSchool(dbn: String): SatScore? {
        val list = api.getSatScores(dbn)
        return list.firstOrNull()?.toDomain()
    }
}
