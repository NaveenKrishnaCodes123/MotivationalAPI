package com.nycschools.data.repository

import com.nycschools.data.local.dao.SchoolDao
import com.nycschools.data.local.entity.SchoolEntity
import com.nycschools.data.remote.ApiService
import com.nycschools.domain.model.School
import com.nycschools.domain.repository.SchoolRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SchoolRepositoryImpl(
    private val api: ApiService,
    private val schoolDao: SchoolDao
) : SchoolRepository {

    override fun getSchools(): Flow<List<School>> = flow {
        val cached = schoolDao.getAll().map { it.toDomain() }
        emit(cached)

        try {
            val dtos = api.getSchools()
            val entities = dtos.mapNotNull { dto ->
                dto.dbn?.let {
                    SchoolEntity(
                        dbn = it,
                        schoolName = dto.schoolName,
                        borough = dto.borough,
                        overviewParagraph = dto.overviewParagraph,
                        phoneNumber = dto.phoneNumber,
                        website = dto.website,
                        city = dto.city,
                        zip = dto.zip
                    )
                }
            }
            schoolDao.insertAll(entities)

            val sats = api.getSats()
            val satMap = sats.associateBy { it.dbn }

            val merged = entities.map { e ->
                val sat = satMap[e.dbn]
                e.toDomain().copy(
                    satReading = sat?.readingAvg,
                    satMath = sat?.mathAvg,
                    satWriting = sat?.writingAvg,
                    satNumOfTakers = sat?.numOfTestTakers
                )
            }

            emit(merged)
        } catch (t: Throwable) {
            // ignore network errors for now
        }
    }

    override suspend fun getSchoolDetail(dbn: String): School? {
        val entity = schoolDao.findByDbn(dbn) ?: return null
        val sat = try {
            api.getSats().firstOrNull { it.dbn == dbn }
        } catch (t: Throwable) { null }

        return entity.toDomain().copy(
            satReading = sat?.readingAvg,
            satMath = sat?.mathAvg,
            satWriting = sat?.writingAvg,
            satNumOfTakers = sat?.numOfTestTakers
        )
    }

    override suspend fun refreshSchools() {
        val dtos = api.getSchools()
        val entities = dtos.mapNotNull { dto ->
            dto.dbn?.let {
                SchoolEntity(
                    dbn = it,
                    schoolName = dto.schoolName,
                    borough = dto.borough,
                    overviewParagraph = dto.overviewParagraph,
                    phoneNumber = dto.phoneNumber,
                    website = dto.website,
                    city = dto.city,
                    zip = dto.zip
                )
            }
        }
        schoolDao.insertAll(entities)
    }
}

private fun SchoolEntity.toDomain() = School(
    dbn = dbn,
    name = schoolName ?: "",
    borough = borough,
    overview = overviewParagraph,
    phone = phoneNumber,
    website = website,
    city = city,
    zip = zip
)
