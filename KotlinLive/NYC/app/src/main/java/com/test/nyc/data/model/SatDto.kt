package com.test.nyc.data.model

import com.squareup.moshi.Json
import com.test.nyc.domain.model.SatScore

data class SatDto(
    val dbn: String,
    val numTestTakers: String,
    val readingAvg: String,
    val mathAvg: String,
    val writingAvg: String
)

fun SatDto.toDomain(): SatScore = SatScore(
    dbn = dbn.orEmpty(),
    numOfTestTakers = numTestTakers.orEmpty(),
    reading = readingAvg.orEmpty(),
    math = mathAvg.orEmpty(),
    writing = writingAvg.orEmpty()
)
