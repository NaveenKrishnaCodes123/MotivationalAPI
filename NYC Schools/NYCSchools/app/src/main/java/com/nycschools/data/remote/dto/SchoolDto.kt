package com.nycschools.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SchoolDto(
    @SerialName("dbn") val dbn: String? = null,
    @SerialName("school_name") val schoolName: String? = null,
    @SerialName("borough") val borough: String? = null,
    @SerialName("overview_paragraph") val overviewParagraph: String? = null,
    @SerialName("phone_number") val phoneNumber: String? = null,
    @SerialName("website") val website: String? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("zip") val zip: String? = null
)
