package com.test.nyc.data.model


import com.test.nyc.domain.model.School

data class SchoolDto(
    val dbn: String,
    val schoolName: String,
    val boro: String,
    val overviewParagraph: String,
    val phoneNumber: String,
    val schoolEmail: String,
    val website: String,
    val address: String,
    val city: String,
    val zip: String,
    val totalStudents: String,
    val latitude: String,
    val longitude: String
)

fun SchoolDto.toDomain(): School = School(
    dbn = dbn.orEmpty(),
    schoolName = schoolName.orEmpty(),
    boro = boro.orEmpty(),
    overviewParagraph = overviewParagraph.orEmpty(),
    phoneNumber = phoneNumber.orEmpty(),
    schoolEmail = schoolEmail.orEmpty(),
    website = website,
    address = listOfNotNull(address, city, zip).joinToString(", "),
    totalStudents = totalStudents.orEmpty(),
    latitude = latitude?.toDoubleOrNull().toString(),
    longitude = longitude?.toDoubleOrNull().toString()
)
