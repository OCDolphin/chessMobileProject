package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class ChessPlayerResult(
  @PrimaryKey
  val id: UUID,
  val chess_daily: ChessStats,
  val chess960_daily: ChessStats,
  val chess_rapid: ChessStats,
  val chess_bullet: ChessStats,
  val chess_blitz: ChessStats,
  val fide: Int,
  val tactics: TacticsStats,
  val puzzle_rush: PuzzleRushStats
)
