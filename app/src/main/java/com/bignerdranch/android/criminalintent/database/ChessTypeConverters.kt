package com.bignerdranch.android.criminalintent.database

import androidx.room.TypeConverter
import java.util.Date

class ChessTypeConverters {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }

}
