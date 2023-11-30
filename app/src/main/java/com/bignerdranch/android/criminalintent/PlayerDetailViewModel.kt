package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.criminalintent.api.ApiHelper
import com.bignerdranch.android.criminalintent.api.ChessApi
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import com.bignerdranch.android.criminalintent.api.GamesResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.create
import java.text.DateFormat
import java.time.format.DateTimeFormatter
import java.util.Date

private const val TAG = "PlayerDetailViewModel"
class PlayerDetailViewModel(val username: String) : ViewModel() {


//    private val chessPlayerRepository = ChessRepository.get()

  private val _chessPlayer: MutableStateFlow<ChessPlayerResult?> = MutableStateFlow(null)
  val chessPlayer: StateFlow<ChessPlayerResult?> = _chessPlayer.asStateFlow()

  private val _games: MutableStateFlow<GamesResult?> = MutableStateFlow(null)
  val games: StateFlow<GamesResult?> = _games.asStateFlow()

  private val api = ApiHelper.getInstance().create<ChessApi>()

  suspend fun init(onFinished: () -> Unit) {
    getPlayerStats(username)
    getPlayerGames(username)
    onFinished()
  }

  private suspend fun getPlayerGames(username: String){
    var current = checkNotNull(api.getPlayerCurrentGames(username).body()) {
      Log.d(TAG, "Failed to get player: [${username}]")
      "Can't find current games from player: [${username}]"
    }
    var monthlyArchive = checkNotNull(api.getPlayerMonthlyArchive(
      username,
      "2023",
      "10"
    ).body()) {
      Log.d(TAG, "Failed to get player: [${username}]")
      "Can't find monthly games from player: [${username}]"
    }

    current.games = current.games + monthlyArchive.games
    _games.value = current

    Log.d(TAG, "Got games from user: [%${username}]:[${_games.value}]")
  }

  private suspend fun getPlayerStats(username: String) {
    val result = checkNotNull(api.getPlayerByName(username).body()) {
      Log.d(TAG, "Failed to get player: [${username}]")
      "Can't find user with name ${username}"
    }
    Log.d(TAG, "[${username}]:[${result}]")
    _chessPlayer.value = result
  }
  override fun onCleared() {
    super.onCleared()
  }
}

class ChessPlayerDetailViewModelFactory(private val username: String) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return PlayerDetailViewModel(username) as T
  }
}
