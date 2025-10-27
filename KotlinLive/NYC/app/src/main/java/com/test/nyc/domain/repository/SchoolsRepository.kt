
package com.test.nyc.domain.repository

import com.test.nyc.domain.model.SatScore
import com.test.nyc.domain.model.School

interface SchoolsRepository {
    suspend fun getSchools(limit: Int, offset: Int, query: String?): List<School>
    suspend fun getSatForSchool(dbn: String): SatScore?
}
