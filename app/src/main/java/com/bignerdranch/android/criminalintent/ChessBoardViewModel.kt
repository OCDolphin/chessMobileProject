package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.criminalintent.api.GameResult
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.pgn.GameLoader

class ChessBoardViewModel(private val game: GameResult): ViewModel() {
  private val pgn = GameLoader.loadNextGame(mutableListOf(game.pgn).iterator())
  private var currentMove = 0
  private val board = Board()

  fun loadFromFen(fen: String) {
    board.loadFromFen(fen)
  }

  fun doMove(san: String) {
    board.doMove(san)
  }

  fun nextMove() {
    board.doMove(pgn.currentMoveList[currentMove++])
  }

  fun prevMove() {
    board.undoMove()
  }

  fun board(): Board{
    return board.clone()
  }
}

class ChessBoardViewModelFactory(private val game: GameResult) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ChessBoardViewModel(game) as T
  }
}
