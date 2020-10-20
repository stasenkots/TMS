package com.example.tms.EightHW.Database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tms.EightHW.Database.entity.Phone

@Dao
interface PhoneDao {

    @Query("SELECT * FROM phone_table")
    suspend fun getAllPhones(): List<Phone>

    @Insert
    suspend fun insertPhone(phone: Phone)

    @Query("DELETE FROM phone_table")
    suspend fun clearPhones()

}