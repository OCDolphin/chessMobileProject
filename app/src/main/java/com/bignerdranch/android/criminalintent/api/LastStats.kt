package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class LastStats(
  val rating: Int,
  val date: Int,
  val rd: Int
)
