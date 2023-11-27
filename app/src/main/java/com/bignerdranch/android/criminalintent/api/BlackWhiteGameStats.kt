package com.bignerdranch.android.criminalintent.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.net.URL
import java.util.UUID

@Parcelize
data class BlackWhiteGameStats(
  val rating: Int,
  val result: String,
  @SerializedName("@id")
  val id: URL,
  val username: String,
  val uuid: UUID
): Parcelable
