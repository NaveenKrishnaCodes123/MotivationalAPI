package com.example.nycschools.data.remote

import com.example.nycschools.data.model.SatScores
import com.example.nycschools.data.model.School
import retrofit2.http.GET

interface ApiService {

    @GET("s3k6-pzi2.json")
    suspend fun getSchools(): List<School>

    @GET("f9bf-2cp4.json")
    suspend fun getSatScores(): List<SatScores>
}