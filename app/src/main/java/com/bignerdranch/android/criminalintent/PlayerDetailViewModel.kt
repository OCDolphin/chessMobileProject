package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.criminalintent.database.ChessPlayer

class PlayerDetailViewModel(val player: ChessPlayer) : ViewModel() {


//    private val chessPlayerRepository = ChessRepository.get()

//    private val _chessPlayer: MutableStateFlow<ChessPlayer?> = MutableStateFlow(null)
//    val chessPlayer: StateFlow<ChessPlayer?> = _chessPlayer.asStateFlow()

  init {
//        viewModelScope.launch {
//            _chessPlayer.value = chessPlayerRepository.getCrime(cPlayer)
//        }
  }

//    fun updatePlayer(onUpdate: (ChessPlayer) -> ChessPlayer) {
////        _chessPlayer.update { oldCrime ->
////            oldCrime?.let {
////                onUpdate(it)
////            }
////        }
//    }

  override fun onCleared() {
    super.onCleared()
//        chessPlayer.value?.let { chessPlayerRepository.updateCrime(it) }
  }
}

class ChessPlayerDetailViewModelFactory(private val player: ChessPlayer) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return PlayerDetailViewModel(player) as T
  }
}
