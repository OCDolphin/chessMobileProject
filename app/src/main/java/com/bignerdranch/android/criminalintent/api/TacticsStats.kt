package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class TacticsStats(
  val highest: TacticsResult,
  val lowest: TacticsResult
)
