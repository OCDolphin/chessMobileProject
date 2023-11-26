package com.bignerdranch.android.criminalintent.api

import java.net.URL
import java.util.Date
import java.util.UUID

data class GameResult(
  val url: URL,
  val pgn: String,
  val timeControl: String,
  val endTime: Date,
  val rated: Boolean,
  val tcn: String,
  val uuid: UUID,
  val initialSetup: String,
  val fen: String,
  val startTime: Date,
  val timeClass: String,
  val rules: String,
  val white: BlackWhiteGameStats,
  val black: BlackWhiteGameStats
)
