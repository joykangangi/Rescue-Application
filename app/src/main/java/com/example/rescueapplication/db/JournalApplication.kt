package com.example.rescueapplication.db

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class JournalApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())


    // Using by lazy so the database are only created when they're needed
    // rather than when the application starts
    val database by lazy { JournalDatabase.invoke(this) }
}