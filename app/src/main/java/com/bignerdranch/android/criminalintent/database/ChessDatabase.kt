package com.bignerdranch.android.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ ChessPlayer::class ], version=1)
@TypeConverters(ChessTypeConverters::class)
abstract class ChessDatabase : RoomDatabase() {
    abstract fun chessPlayerDao(): ChessPlayerDao
}
