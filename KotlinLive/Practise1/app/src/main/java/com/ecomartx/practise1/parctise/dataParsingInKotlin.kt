package com.ecomartx.practise1.parctise

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class User(
    val name: String,
    val age: Int,
    val mobileNumber: String
)

interface ApiService{
    @GET("users")
    suspend fun getUsers(): List<User>
}

val retrofit= Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build()

val api= retrofit.create(ApiService::class.java)
