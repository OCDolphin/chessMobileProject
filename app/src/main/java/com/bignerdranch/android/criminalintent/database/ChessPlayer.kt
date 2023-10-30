package com.bignerdranch.android.criminalintent.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult

@Entity
data class ChessPlayer(@PrimaryKey val username: String)
