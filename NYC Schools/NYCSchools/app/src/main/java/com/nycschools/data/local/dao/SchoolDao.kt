package com.nycschools.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nycschools.data.local.entity.SchoolEntity

@Dao
interface SchoolDao {
    @Query("SELECT * FROM schools")
    suspend fun getAll(): List<SchoolEntity>

    @Query("SELECT * FROM schools WHERE dbn = :dbn LIMIT 1")
    suspend fun findByDbn(dbn: String): SchoolEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(schools: List<SchoolEntity>)
}
