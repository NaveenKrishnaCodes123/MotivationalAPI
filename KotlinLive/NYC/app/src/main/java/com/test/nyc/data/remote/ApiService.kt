
package com.test.nyc.data.remote

import com.test.nyc.data.model.SchoolDto
import com.test.nyc.data.model.SatDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Socrata supports $limit and $offset query parameters; using @Query("\$limit") to send them
    @GET("/resource/s3k6-pzi2.json")
    suspend fun getSchools(
        @Query("\$limit") limit: Int = 50,
        @Query("\$offset") offset: Int = 0,
        @Query("q") q: String? = null
    ): List<SchoolDto>

    // SAT scores endpoint - filter by dbn
    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSatScores(
        @Query("dbn") dbn: String? = null
    ): List<SatDto>
}
