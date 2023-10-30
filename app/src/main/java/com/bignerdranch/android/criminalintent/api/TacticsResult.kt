package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class TacticsResult (
  val rating: Int,
  val date: Int
)
