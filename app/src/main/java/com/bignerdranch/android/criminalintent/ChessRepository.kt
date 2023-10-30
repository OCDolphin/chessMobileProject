package com.bignerdranch.android.criminalintent

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.criminalintent.database.ChessDatabase
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

private const val DATABASE_NAME = "chess-database"

class ChessRepository private constructor(
  context: Context,
  private val coroutineScope: CoroutineScope = GlobalScope
) {

  private val database: ChessDatabase = Room
    .databaseBuilder(
      context.applicationContext,
      ChessDatabase::class.java,
      DATABASE_NAME
    )
    .build()

  fun getPlayers(): Flow<List<ChessPlayer>> = database.chessPlayerDao().getPlayers()

  suspend fun getPlayerByUsername(username: String): ChessPlayer =
    database.chessPlayerDao().getPlayerByUsername(username)

  fun updatePlayer(chessPlayer: ChessPlayer) {
    coroutineScope.launch {
      database.chessPlayerDao().updatePlayer(chessPlayer)
    }
  }

  suspend fun addPlayer(player: ChessPlayer) {
    database.chessPlayerDao().addPlayer(player)
  }

  companion object {
    private var INSTANCE: ChessRepository? = null

    fun initialize(context: Context) {
      if (INSTANCE == null) {
        INSTANCE = ChessRepository(context)
      }
    }

    fun get(): ChessRepository {
      return INSTANCE
        ?: throw IllegalStateException("CrimeRepository must be initialized")
    }
  }
}
