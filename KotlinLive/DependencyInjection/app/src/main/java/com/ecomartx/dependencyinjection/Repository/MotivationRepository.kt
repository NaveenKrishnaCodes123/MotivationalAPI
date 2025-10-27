package com.ecomartx.dependencyinjection.Repository

import com.ecomartx.dependencyinjection.Model.MotivationalApi
import com.ecomartx.dependencyinjection.Model.MotivationalPhrase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MotivationRepository @Inject constructor(
    private val api: MotivationalApi
) {
    fun getQuotes(): Flow<List<MotivationalPhrase>> = flow {
        emit(api.getQuotes())
    }.catch { e ->
        e.printStackTrace()
        emit(emptyList())
    }
}