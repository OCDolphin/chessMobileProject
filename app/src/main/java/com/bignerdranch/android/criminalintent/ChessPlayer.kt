package com.bignerdranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class ChessPlayer(
//    @PrimaryKey val id: UUID,
//    val title: String,
//    val date: Date,
//    val isSolved: Boolean,




    @PrimaryKey val user : String,

    val daily_last_rating : Int,
    val daily_last_date : Int,
    val daily_last_rd : Int,
    val daily_best_rating: Int,
    val daily_best_date : Int,
    val daily_best_game_url : String,
    val daily_record_win : Int,
    val daily_record_loss : Int,
    val daily_record_draw : Int,
    val daily_record_time_per_move : Int,
    val daily_record_timeout_percent : Int,


    val daily_960_last_rating : Int,
    val daily_960_last_date : Int,
    val daily_960_last_rd : Int,
    val daily_960_best_rating: Int,
    val daily_960_best_date : Int,
    val daily_960_best_game_url : String,
    val daily_960_record_win : Int,
    val daily_960_record_loss : Int,
    val daily_960_record_draw : Int,
    val daily_960_record_time_per_move : Int,
    val daily_960_record_timeout_percent : Int,

    val rapid_last_rating : Int,
    val rapid_last_date : Int,
    val rapid_last_rd : Int,
    val rapid_best_rating: Int,
    val rapid_best_date : Int,
    val rapid_best_game_url : String,
    val rapid_record_win : Int,
    val rapid_record_loss : Int,
    val rapid_record_draw : Int,

    val bullet_last_rating : Int,
    val bullet_last_date : Int,
    val bullet_last_rd : Int,
    val bullet_best_rating: Int,
    val bullet_best_date : Int,
    val bullet_best_game_url : String,
    val bullet_record_win : Int,
    val bullet_record_loss : Int,
    val bullet_record_draw : Int,

    val blitz_last_rating : Int,
    val blitz_last_date : Int,
    val blitz_last_rd : Int,
    val blitz_best_rating: Int,
    val blitz_best_date : Int,
    val blitz_best_game_url : String,
    val blitz_record_win : Int,
    val blitz_record_loss : Int,
    val blitz_record_draw : Int,

    val fide : Int,

    val tactics_highest_rating : Int,
    val tactics_highest_rating_date: Int,
    val tactics_lowest_rating : Int,
    val tactics_lowest_rating_date : Int,

    val puzzle_rush_best_total_attempts : Int,
    val puzzle_rush_best_score: Int
)