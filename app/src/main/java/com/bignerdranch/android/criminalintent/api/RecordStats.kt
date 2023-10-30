package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class RecordStats(
  val win: Int,
  val loss: Int,
  val draw: Int,
  val time_per_move: Int = 0 ,
  val timeout_percent: Int = 0
)
