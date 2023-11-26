package com.bignerdranch.android.criminalintent

import java.net.URL
import java.util.Date

data class Pgn(
  val event: String,
  val site: String,
  val date: Date,
  val round: Int?,
  val whitePlayerUsername: String,
  val blackPlayerUsername: String,
  val result: String,
  val currentPosition: String,
  val timezone: String,
  val ECO: String,
  val ECOurl: URL,
  val UTCDate: Date,
  val UTCTime: Date,
  val whiteElo: Int,
  val blackElo: Int,
  val timeControl: String,
  val termination: String,
  val startTime: Date,
  val endDate: Date,
  val endTime: Date,
  val link: URL
)
