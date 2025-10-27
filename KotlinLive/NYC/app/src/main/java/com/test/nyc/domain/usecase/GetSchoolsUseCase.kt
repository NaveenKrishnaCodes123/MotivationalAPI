
package com.test.nyc.domain.usecase

import com.test.nyc.domain.model.School
import com.test.nyc.domain.repository.SchoolsRepository

class GetSchoolsUseCase(private val repo: SchoolsRepository) {
    suspend operator fun invoke(limit: Int, offset: Int, query: String?): List<School> =
        repo.getSchools(limit, offset, query)
}
