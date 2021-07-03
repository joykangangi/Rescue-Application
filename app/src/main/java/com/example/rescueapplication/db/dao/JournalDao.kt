package com.example.rescueapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rescueapplication.db.entity.JournalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query ("SELECT * FROM journals ORDER BY date ASC")
    fun selectAllJournals(): LiveData<List<JournalEntity>>
    /**
     * What is live data?
     * An observable data class that is lifecycle-aware.
     */

    @Insert (onConflict = OnConflictStrategy.REPLACE) //update or insert a journal
    fun upsert(journalEntity: JournalEntity)

    @Delete
    fun deleteJournal(journalEntity: JournalEntity)

}