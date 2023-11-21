package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.api.ApiHelper
import com.bignerdranch.android.criminalintent.api.ChessApi
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.create

private const val TAG = "PlayerDetailViewModel"
class PlayerDetailViewModel(val username: String) : ViewModel() {


//    private val chessPlayerRepository = ChessRepository.get()

  private val _chessPlayer: MutableStateFlow<ChessPlayerResult?> = MutableStateFlow(null)
  val chessPlayer: StateFlow<ChessPlayerResult?> = _chessPlayer.asStateFlow()

  private val api = ApiHelper.getInstance().create<ChessApi>()

  suspend fun init(onFinished: () -> Unit) {
    val result = checkNotNull(api.getPlayerByName(username).body()) {
      Log.d(TAG, "Failed to get player: [${username}]")
      "Can't find user with name ${username}"
    }
    Log.d(TAG, "[${username}]:[${result}]")
    _chessPlayer.value = result
    onFinished()
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
