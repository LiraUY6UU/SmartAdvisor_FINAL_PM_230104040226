package com.example.smartadvisor.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserEntity::class, AcademicRecordEntity::class, ConsultationEntity::class],
    version = 1,
    exportSchema = false // Tambahkan ini
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): SmartAdvisorDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(context, AppDatabase::class.java, "smart_advisor.db")
                .fallbackToDestructiveMigration()
                .build().also { instance = it }
        }
    }
}