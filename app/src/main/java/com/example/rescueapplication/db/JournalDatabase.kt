package com.example.rescueapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rescueapplication.db.dao.JournalDao
import com.example.rescueapplication.db.entity.JournalEntity


@Database(
    entities = [JournalEntity::class],
    version = 1, exportSchema = false)

 abstract class JournalDatabase: RoomDatabase() {
     abstract fun journalDao(): JournalDao


     //singleton to ensure there is only one instance at a time for the db
     companion object {
         @Volatile private var instance: JournalDatabase? = null //@Volatile ensures all other threads are made aware of the instantiation of the db
         private var LOCK = Any()
         //invoke fun will be executed on any instance of the db without a method name

         operator fun invoke (context: Context) = instance?: synchronized(LOCK) {
             instance?: createDatabase(context).also { instance = it }
             }



         private fun createDatabase(context: Context) =
             Room.databaseBuilder(context.applicationContext, JournalDatabase::class.java, "journal.db").build()

     }
}