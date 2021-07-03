package com.example.rescueapplication.screens.journals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rescueapplication.db.dao.JournalDao

class JournalViewModelFactory(private val dao: JournalDao): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JournalViewModel(dao) as T
    }

}