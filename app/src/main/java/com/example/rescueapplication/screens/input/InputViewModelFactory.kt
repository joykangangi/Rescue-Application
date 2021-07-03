package com.example.rescueapplication.screens.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rescueapplication.db.dao.JournalDao


/**
 * Why do we need a ViewModelFactory?
 * As you can see from the previous ViewModel configuration, there is no way of passing arguments
 * to the constructor of the viewmodel.
 * A viewModelFactory creates a new instance of the viewmodel and passes the required arguments.(with/without constructor parameters)
 * if a viewModel instance is made in the viewModel class, a new object is created every time the fragment is re-created
 */
class InputViewModelFactory(private var dao: JournalDao):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InputViewModel(dao) as T
    }
}