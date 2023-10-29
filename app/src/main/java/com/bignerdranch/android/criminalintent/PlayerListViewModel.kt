package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "CrimeListViewModel"

class PlayerListViewModel : ViewModel() {
    private val chessPlayerRepository = ChessPlayerRepository.get()

    private val _crimes: MutableStateFlow<List<ChessPlayer>> = MutableStateFlow(emptyList())

    val crimes: StateFlow<List<ChessPlayer>>
        get() = _crimes.asStateFlow()

    init {
        val c1 = ChessPlayer(
        user = "ocdolphin",

        daily_last_rating = 69,
        daily_last_date = 420,
        daily_last_rd = 420,
        daily_best_rating= 420,
        daily_best_date = 420,
        daily_best_game_url = "papajohns.com",
        daily_record_win = 420,
        daily_record_loss = 420,
        daily_record_draw = 420,
        daily_record_time_per_move = 420,
        daily_record_timeout_percent = 420,


        daily_960_last_rating = 420,
        daily_960_last_date = 420,
        daily_960_last_rd = 420,
        daily_960_best_rating= 420,
        daily_960_best_date = 420,
        daily_960_best_game_url = "papajohns.com",
        daily_960_record_win = 420,
        daily_960_record_loss = 420,
        daily_960_record_draw = 420,
        daily_960_record_time_per_move = 420,
        daily_960_record_timeout_percent = 420,

        rapid_last_rating = 420,
        rapid_last_date = 420,
        rapid_last_rd = 420,
        rapid_best_rating= 420,
        rapid_best_date = 420,
        rapid_best_game_url = "papajohns.com",
        rapid_record_win = 420,
        rapid_record_loss = 420,
        rapid_record_draw = 420,

        bullet_last_rating = 420,
        bullet_last_date = 420,
        bullet_last_rd = 420,
        bullet_best_rating= 420,
        bullet_best_date = 420,
        bullet_best_game_url = "papajohns.com",
        bullet_record_win = 420,
        bullet_record_loss = 420,
        bullet_record_draw = 420,

        blitz_last_rating = 420,
        blitz_last_date = 420,
        blitz_last_rd = 420,
        blitz_best_rating= 420,
        blitz_best_date = 420,
        blitz_best_game_url = "papajohns.com",
        blitz_record_win = 420,
        blitz_record_loss = 420,
        blitz_record_draw = 420,

        fide = 420,

        tactics_highest_rating = 420,
        tactics_highest_rating_date= 420,
        tactics_lowest_rating = 420,
        tactics_lowest_rating_date = 420,

        puzzle_rush_best_total_attempts = 420,
        puzzle_rush_best_score= 420
        )

        viewModelScope.launch {
            chessPlayerRepository.getCrimes().collect {
                _crimes.value = it
            }
        }


    }

    suspend fun addCrime(chessPlayer: ChessPlayer) {
        chessPlayerRepository.addCrime(chessPlayer)
    }
}