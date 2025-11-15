package com.nycschools.domain.repository

import com.nycschools.domain.model.School
import kotlinx.coroutines.flow.Flow

interface SchoolRepository {
    fun getSchools(): Flow<List<School>>
    suspend fun getSchoolDetail(dbn: String): School?
    suspend fun refreshSchools()
}
