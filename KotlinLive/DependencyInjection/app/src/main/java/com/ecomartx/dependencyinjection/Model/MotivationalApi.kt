package com.ecomartx.dependencyinjection.Model

import retrofit2.http.GET

interface MotivationalApi {
    @GET("en.json")
    suspend fun getQuotes(): List<MotivationalPhrase>
}