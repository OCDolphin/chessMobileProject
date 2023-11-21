package com.bignerdranch.android.criminalintent.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class LastStats(
  val rating: Int,
  val date: Int,
  val rd: Int
): Parcelable
