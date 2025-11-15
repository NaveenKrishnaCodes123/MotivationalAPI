package com.example.nycschools.domain.usecase

import com.example.nycschools.data.model.School
import com.example.nycschools.data.repository.SchoolRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSchoolsUseCase @Inject constructor(
    private val repository: SchoolRepository
) {
    operator fun invoke(): Flow<List<School>> = repository.getSchools()
}