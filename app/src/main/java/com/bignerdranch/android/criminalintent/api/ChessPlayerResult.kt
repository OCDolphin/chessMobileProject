package com.bignerdranch.android.criminalintent.api

import androidx.room.Entity

@Entity
data class ChessPlayerResult(
    val chess_daily: ChessStats,
    val chess960_daily: ChessStats,
    val chess_rapid: ChessStats,
    val chess_bullet: ChessStats,
    val chess_blitz: ChessStats,
    val fide: Int,
    val tactics: TacticsStats,
    val puzzle_rush: PuzzleRushStats
)
