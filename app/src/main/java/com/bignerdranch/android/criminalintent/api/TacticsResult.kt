package com.bignerdranch.android.criminalintent.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class TacticsResult (
  val rating: Int,
  val date: Int
): Parcelable
