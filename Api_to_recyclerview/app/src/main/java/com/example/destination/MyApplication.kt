package com.example.destination

import android.app.Application
import com.example.destination.data.preferences.PreferenceManager

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceManager.init(this)
    }
}