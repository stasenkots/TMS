package com.example.tms.EightHW.Database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phone_table")
data class Phone(
    @PrimaryKey
    val model:String,
    val os: String,
    val price:Double
) {

}
