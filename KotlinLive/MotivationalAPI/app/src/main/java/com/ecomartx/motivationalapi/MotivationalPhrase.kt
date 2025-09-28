package com.ecomartx.motivationalapi

import androidx.compose.runtime.Immutable

@Immutable
data class MotivationalPhrase(
    val id: Int,
    val phrase: String,
    val author: String,
    val religion: Int
)

@Immutable
data class MotivationalResponse(
    val phrases: List<MotivationalPhrase>
)