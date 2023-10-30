package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "PlayerListViewModel"

class PlayerListViewModel : ViewModel() {
    private val chessPlayerRepository = ChessRepository.get()

    private val _players: MutableStateFlow<List<ChessPlayer>> = MutableStateFlow(emptyList())

    val players: StateFlow<List<ChessPlayer>>
        get() = _players.asStateFlow()

    init {
      viewModelScope.launch {

      }
    }

    suspend fun addPlayer(chessPlayer: ChessPlayer) {
        chessPlayerRepository.addPlayer(chessPlayer)
    }
}
