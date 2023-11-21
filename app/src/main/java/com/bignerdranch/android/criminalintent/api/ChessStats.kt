package com.bignerdranch.android.criminalintent.api

import android.os.Parcel
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class ChessStats (
  val last: LastStats,
  val best: BestStats,
  val record: RecordStats
): Parcelable
