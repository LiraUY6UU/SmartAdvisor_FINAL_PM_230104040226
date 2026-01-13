package com.example.smartadvisor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SmartAdvisorDao {
    // Auth
    @Query("SELECT * FROM users WHERE id = :uid AND password = :pass")
    suspend fun login(uid: String, pass: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    // Academic
    @Query("SELECT * FROM academic_records WHERE studentId = :uid")
    suspend fun getRecords(uid: String): List<AcademicRecordEntity>

    @Insert
    suspend fun insertRecord(record: AcademicRecordEntity)

    // Consultation
    @Insert
    suspend fun insertConsultation(consultation: ConsultationEntity)

    @Query("SELECT * FROM consultations")
    fun getAllConsultations(): Flow<List<ConsultationEntity>>

    @Query("UPDATE consultations SET status = :status WHERE id = :id")
    suspend fun updateStatus(id: Int, status: String)

}