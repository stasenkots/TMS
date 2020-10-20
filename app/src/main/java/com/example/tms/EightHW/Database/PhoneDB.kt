package com.example.tms.EightHW.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tms.EightHW.Database.dao.PhoneDao
import com.example.tms.EightHW.Database.entity.Phone

@Database(entities = arrayOf(Phone::class), version = 1)
abstract class BuilderPhoneDB : RoomDatabase() {
    abstract fun phoneDao(): PhoneDao

}

object PhoneDB {
    fun getDataBase(context: Context) =
        Room.databaseBuilder(context, BuilderPhoneDB::class.java, "PhoneDataBase").build()
}