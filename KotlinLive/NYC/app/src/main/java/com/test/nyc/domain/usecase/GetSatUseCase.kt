
package com.test.nyc.domain.usecase

import com.test.nyc.domain.model.SatScore
import com.test.nyc.domain.repository.SchoolsRepository

class GetSatUseCase(private val repo: SchoolsRepository) {
    suspend operator fun invoke(dbn: String): SatScore? = repo.getSatForSchool(dbn)
}
