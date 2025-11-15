package com.nycschools.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SatDto(
    @SerialName("dbn") val dbn: String? = null,
    @SerialName("school_name") val schoolName: String? = null,
    @SerialName("num_of_sat_test_takers") val numOfTestTakers: String? = null,
    @SerialName("sat_critical_reading_avg_score") val readingAvg: String? = null,
    @SerialName("sat_math_avg_score") val mathAvg: String? = null,
    @SerialName("sat_writing_avg_score") val writingAvg: String? = null
)
