package com.bignerdranch.android.criminalintent.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import java.util.UUID

@Entity
data class ChessPlayer(val username: String, @PrimaryKey val id: UUID)
