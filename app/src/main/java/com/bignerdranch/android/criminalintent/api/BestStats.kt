package com.bignerdranch.android.criminalintent.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BestStats (
  val rating: Int,
  val date: Int,
  val game: String
): Parcelable
