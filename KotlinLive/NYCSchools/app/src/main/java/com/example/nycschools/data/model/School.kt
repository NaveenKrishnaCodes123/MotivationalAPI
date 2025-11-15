package com.example.nycschools.data.model

import com.google.gson.annotations.SerializedName

data class School(
    @SerializedName("dbn")
    val dbn: String,

    @SerializedName("school_name")
    val schoolName: String,

    @SerializedName("overview_paragraph")
    val overview: String?,

    @SerializedName("location")
    val location: String?,

    @SerializedName("phone_number")
    val phoneNumber: String?,

    @SerializedName("school_email")
    val email: String?,

    @SerializedName("website")
    val website: String?,

    @SerializedName("total_students")
    val totalStudents: String?,

    @SerializedName("graduation_rate")
    val graduationRate: String?,

    @SerializedName("attendance_rate")
    val attendanceRate: String?
)