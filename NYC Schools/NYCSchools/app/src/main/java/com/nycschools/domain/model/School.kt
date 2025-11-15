package com.nycschools.domain.model

data class School(
    val dbn: String,
    val name: String,
    val borough: String?,
    val overview: String?,
    val phone: String?,
    val website: String?,
    val city: String?,
    val zip: String?,
    val satReading: String? = null,
    val satMath: String? = null,
    val satWriting: String? = null,
    val satNumOfTakers: String? = null
)
