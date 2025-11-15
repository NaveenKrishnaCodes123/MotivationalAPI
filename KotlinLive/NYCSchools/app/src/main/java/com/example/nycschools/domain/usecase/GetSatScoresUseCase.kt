package com.example.nycschools.domain.usecase

import com.example.nycschools.data.model.SatScores
import com.example.nycschools.data.repository.SchoolRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSatScoresUseCase @Inject constructor(
    private val repository: SchoolRepository
) {
    operator fun invoke(dbn: String): Flow<SatScores?> = repository.getSatScoresByDbn(dbn)
}