package com.nycschools.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schools")
data class SchoolEntity(
    @PrimaryKey val dbn: String,
    val schoolName: String?,
    val borough: String?,
    val overviewParagraph: String?,
    val phoneNumber: String?,
    val website: String?,
    val city: String?,
    val zip: String?
)
