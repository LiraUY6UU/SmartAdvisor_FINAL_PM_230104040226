package com.example.smartadvisor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String, // NIM atau NIP
    val name: String,
    val password: String,
    val role: String // "STUDENT" atau "ADVISOR"
)