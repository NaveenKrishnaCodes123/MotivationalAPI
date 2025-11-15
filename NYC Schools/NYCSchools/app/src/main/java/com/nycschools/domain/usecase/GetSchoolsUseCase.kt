package com.nycschools.domain.usecase

import com.nycschools.domain.model.School
import com.nycschools.domain.repository.SchoolRepository
import kotlinx.coroutines.flow.Flow

class GetSchoolsUseCase(private val repo: SchoolRepository) {
    operator fun invoke(): Flow<List<School>> = repo.getSchools()
}
