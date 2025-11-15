package com.example.nycschools.data.model

import com.google.gson.annotations.SerializedName

data class SatScores(
    @SerializedName("dbn")
    val dbn: String,

    @SerializedName("school_name")
    val schoolName: String,

    @SerializedName("num_of_sat_test_takers")
    val testTakers: String?,

    @SerializedName("sat_critical_reading_avg_score")
    val readingScore: String?,

    @SerializedName("sat_math_avg_score")
    val mathScore: String?,

    @SerializedName("sat_writing_avg_score")
    val writingScore: String?
)