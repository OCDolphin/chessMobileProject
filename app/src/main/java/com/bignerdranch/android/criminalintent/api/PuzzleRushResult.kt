package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class PuzzleRushResult (
  val total_attempts: Int,
  val score: Int
)
