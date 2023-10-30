package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class PuzzleRushStats(
  val best: PuzzleRushResult
)
