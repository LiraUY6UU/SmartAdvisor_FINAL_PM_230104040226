package com.example.smartadvisor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "academic_records")
data class AcademicRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val studentId: String,
    val courseName: String,
    val grade: String,
    val sks: Int
)