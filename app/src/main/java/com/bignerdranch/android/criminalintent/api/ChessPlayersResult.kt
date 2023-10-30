package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class ChessPlayersResult (
  val players: List<String>
)
