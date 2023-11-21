package com.bignerdranch.android.criminalintent.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class PuzzleRushResult (
  val total_attempts: Int,
  val score: Int
): Parcelable
