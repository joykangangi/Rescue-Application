package com.example.rescueapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "journals")
data class JournalEntity(
    @ColumnInfo var title: String,
    @ColumnInfo var description: String,
   @ColumnInfo var date: String
) {
    @PrimaryKey (autoGenerate = true) var id: Int? = null


}



