package com.bignerdranch.android.criminalintent.api

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable
import java.util.UUID

@Parcelize
data class ChessPlayerResult(
  val chess_daily: ChessStats,
  val chess960_daily: ChessStats,
  val chess_rapid: ChessStats,
  val chess_bullet: ChessStats,
  val chess_blitz: ChessStats,
  val fide: Int,
  val tactics: TacticsStats,
  val puzzle_rush: PuzzleRushStats
): Parcelable
