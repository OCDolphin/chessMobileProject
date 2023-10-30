package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class BestStats (
  val rating: Int,
  val date: Int,
  val game: String
)
