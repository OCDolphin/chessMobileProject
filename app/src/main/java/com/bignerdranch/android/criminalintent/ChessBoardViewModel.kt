package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChessBoardViewModel(private val piecePositions: String): ViewModel() {
}

class ChessBoardViewModelFactory(private val piecePositions: String) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ChessBoardViewModel(piecePositions) as T
  }
}
