package com.nycschools

import com.nycschools.domain.model.School
import com.nycschools.domain.repository.SchoolRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSchoolRepository : SchoolRepository {
    var schoolsList: List<School> = emptyList()
    var schoolDetail: School? = null

    override fun getSchools(): Flow<List<School>> = flow {
        emit(schoolsList)
    }

    override suspend fun getSchoolDetail(dbn: String): School? {
        return schoolDetail
    }

    override suspend fun refreshSchools() {
        TODO("Not yet implemented")
    }
}