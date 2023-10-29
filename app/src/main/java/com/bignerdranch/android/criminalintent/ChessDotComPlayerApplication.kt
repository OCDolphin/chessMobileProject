package com.bignerdranch.android.criminalintent

import android.app.Application

class ChessDotComPlayerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ChessPlayerRepository.initialize(this)
    }
}