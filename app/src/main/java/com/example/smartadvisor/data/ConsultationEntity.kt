package com.example.smartadvisor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consultations") // <--- WAJIB ADA INI
data class ConsultationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val studentId: String,
    val studentName: String,
    val date: String,
    val topic: String,
    val status: String = "PENDING"
)