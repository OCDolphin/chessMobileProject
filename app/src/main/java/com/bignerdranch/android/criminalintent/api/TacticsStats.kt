package com.bignerdranch.android.criminalintent.api

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class TacticsStats(
  val highest: TacticsResult,
  val lowest: TacticsResult
): Parcelable
