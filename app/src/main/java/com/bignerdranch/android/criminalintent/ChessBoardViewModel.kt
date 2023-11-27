package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.criminalintent.api.GameResult

class ChessBoardViewModel(private val game: GameResult): ViewModel() {
}

class ChessBoardViewModelFactory(private val game: GameResult) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ChessBoardViewModel(game) as T
  }
}
