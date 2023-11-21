package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.api.ApiHelper
import com.bignerdranch.android.criminalintent.api.ChessApi
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "PlayerListViewModel"

class PlayerListViewModel : ViewModel() {
  private val chessPlayerRepository = ChessRepository.get()
  private val api = ApiHelper.getInstance().create(ChessApi::class.java)

  private val _players: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

  val players: StateFlow<List<String>>
    get() = _players.asStateFlow()

  init {
    viewModelScope.launch {
      _players.value = api.getTitledPlayers("GM").body()?.players!!
      Log.d(TAG, _players.value.toString())
    }
  }

  suspend fun addPlayer(chessPlayer: ChessPlayer) {
    chessPlayerRepository.addPlayer(chessPlayer)
  }
}
