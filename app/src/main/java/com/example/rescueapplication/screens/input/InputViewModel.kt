package com.example.rescueapplication.screens.input

import android.util.Log
import androidx.lifecycle.*
import com.example.rescueapplication.db.dao.JournalDao
import com.example.rescueapplication.db.entity.JournalEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InputViewModel(private val dao: JournalDao): ViewModel() {
    fun saveJournal(journalTitle: String, journalDesc: String, date: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val journalEntry =
                    JournalEntity(title = journalTitle, description = journalDesc, date = date)
                dao.upsert(journalEntry)
                Log.i("InputViewModel", "The journal has been saved on $date")
            }
        }
    }

    private var _theTitle = MutableLiveData<String>()
    val theTitle: LiveData<String> = _theTitle

    private var _theDesc = MutableLiveData<String>()
    val theDesc: LiveData<String> = _theDesc

    fun passTheMessage(pTitle: String, pDesc: String){
        _theTitle.value = pTitle
        _theDesc.value = pDesc
    }


}