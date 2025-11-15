package com.nycschools.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.nycschools.data.local.dao.SchoolDao
import com.nycschools.data.local.entity.SchoolEntity

@Database(entities = [SchoolEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun schoolDao(): SchoolDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "nyc_schools_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
