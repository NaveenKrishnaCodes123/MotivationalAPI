package com.nycschools.di

import android.util.Log
import com.nycschools.data.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

object ServiceLocator {

    private const val BASE_URL = "https://data.cityofnewyork.us"

    // JSON config for Kotlinx Serialization
    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    // Custom Logging Interceptor
    private val logging = HttpLoggingInterceptor { message ->
        Log.d("API_LOG", message)
    }.apply {
        // BODY will show everything — request, headers, and response
        level = HttpLoggingInterceptor.Level.BODY
    }

    // OkHttpClient with logging enabled
    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    // Retrofit with Kotlinx Serialization
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val api: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
