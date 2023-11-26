package com.bignerdranch.android.criminalintent.api

import com.google.gson.annotations.SerializedName
import java.net.URL
import java.util.UUID

data class BlackWhiteGameStats(
  val rating: Int,
  val result: String,
  @SerializedName("@id")
  val id: URL,
  val username: String,
  val uuid: UUID
)
