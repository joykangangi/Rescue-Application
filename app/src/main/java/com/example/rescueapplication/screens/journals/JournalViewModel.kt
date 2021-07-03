   package com.example.rescueapplication.screens.journals

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rescueapplication.db.dao.JournalDao

class JournalViewModel(dao: JournalDao): ViewModel() {
val journalList = dao.selectAllJournals()


    override fun onCleared() {
        super.onCleared()
        Log.i("Journal View Model", "Journal View Model is destroyed!")
    }
}