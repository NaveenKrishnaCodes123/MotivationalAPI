package com.ecomartx.motivationalapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Interface
interface MotivationalApiService {
    @GET("en.json")
    suspend fun getMotivationalPhrases(): List<MotivationalPhrase>
}

//Retrofit
open class MotivationalRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gomezmig03.github.io/MotivationalAPI/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(MotivationalApiService::class.java)

    open suspend fun getPhrases(): List<MotivationalPhrase> {
        return try {
            apiService.getMotivationalPhrases()
        } catch (e: Exception) {
            emptyList()
        }
    }
}