package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SatScores
import com.example.nycschools.data.model.School
import com.example.nycschools.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface SchoolRepository {
    fun getSchools(): Flow<List<School>>
    fun getSatScores(): Flow<List<SatScores>>
    fun getSatScoresByDbn(dbn: String): Flow<SatScores?>
}

class SchoolRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SchoolRepository {

    override fun getSchools(): Flow<List<School>> = flow {
        try {
            val schools = apiService.getSchools()
            emit(schools)
        } catch (e: Exception) {
            // In a production app, you might want to handle errors differently
            // For now, we'll emit an empty list on error
            emit(emptyList())
        }
    }

    override fun getSatScores(): Flow<List<SatScores>> = flow {
        try {
            val scores = apiService.getSatScores()
            emit(scores)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    override fun getSatScoresByDbn(dbn: String): Flow<SatScores?> = flow {
        try {
            val allScores = apiService.getSatScores()
            val scoresForSchool = allScores.find { it.dbn == dbn }
            emit(scoresForSchool)
        } catch (e: Exception) {
            emit(null)
        }
    }
}