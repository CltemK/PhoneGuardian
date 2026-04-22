package com.phoneguardian

import androidx.work.Configuration
import com.phoneguardian.data.local.AppDatabase

class PhoneGuardianApp : android.app.Application(), Configuration.Provider {

    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.getInstance(this)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()

    companion object {
        lateinit var instance: PhoneGuardianApp
            private set
    }
}
