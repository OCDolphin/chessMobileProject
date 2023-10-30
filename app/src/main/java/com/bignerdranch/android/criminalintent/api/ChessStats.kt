package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class ChessStats (
  val last: LastStats,
  val best: BestStats,
  val record: RecordStats
)
