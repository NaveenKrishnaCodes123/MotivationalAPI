package com.test.nyc.domain.model


data class School(
    val dbn: String,
    val schoolName: String,
    val boro: String? = null,
    val overviewParagraph: String? = null,
    val academicOpportunities1: String? = null,
    val academicOpportunities2: String? = null,
    val neighborhood: String? = null,
    val location: String? = null,
    val phoneNumber: String? = null,
    val website: String? = null,
    val totalStudents: String? = null,
    val attendanceRate: String? = null,
    val finalGrades: String? = null,
    val extracurricularActivities: String? = null,
    val schoolSports: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val address: String,
    val schoolEmail: String
)
