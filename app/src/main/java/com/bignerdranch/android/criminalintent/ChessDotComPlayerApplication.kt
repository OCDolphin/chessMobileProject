package com.bignerdranch.android.criminalintent

import android.app.Application
import android.util.Log

private const val TAG = "ChessDotComPlayerApplication"
class ChessDotComPlayerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ChessRepository.initialize(this)
        Log.d(TAG, "onCreate called")
    }
}
