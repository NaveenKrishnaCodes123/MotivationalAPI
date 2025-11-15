package com.nycschools.data.remote

import com.nycschools.data.remote.dto.SchoolDto
import com.nycschools.data.remote.dto.SatDto
import retrofit2.http.GET

interface ApiService {
    @GET("/resource/s3k6-pzi2.json")
    suspend fun getSchools(): List<SchoolDto>

    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSats(): List<SatDto>
}
