package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CrimeDetailViewModel(cPlayer: String): ViewModel() {
    private val chessPlayerRepository = ChessPlayerRepository.get()

    private val _chessPlayer: MutableStateFlow<ChessPlayer?> = MutableStateFlow(null)
    val chessPlayer: StateFlow<ChessPlayer?> = _chessPlayer.asStateFlow()

    init {
        viewModelScope.launch {
            _chessPlayer.value = chessPlayerRepository.getCrime(cPlayer)
        }
    }

    fun updateCrime(onUpdate: (ChessPlayer) -> ChessPlayer) {
        _chessPlayer.update { oldCrime ->
            oldCrime?.let {
                onUpdate(it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        chessPlayer.value?.let { chessPlayerRepository.updateCrime(it) }
    }
}

class CrimeDetailViewModelFactory(private val cPlayer: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CrimeDetailViewModel(cPlayer) as T
    }
}