package com.bignerdranch.android.criminalintent

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.criminalintent.api.ApiHelper
import com.bignerdranch.android.criminalintent.api.ChessApi
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import com.bignerdranch.android.criminalintent.api.GamesResult
import com.bignerdranch.android.criminalintent.database.ChessDatabase
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.create
import java.lang.Exception
import java.util.UUID

private const val DATABASE_NAME = "chess-database"

class ChessRepository private constructor(
  context: Context,
  private val coroutineScope: CoroutineScope = GlobalScope
) {
  private val api = ApiHelper.getInstance().create<ChessApi>()

  private val database: ChessDatabase = Room
    .databaseBuilder(
      context.applicationContext,
      ChessDatabase::class.java,
      DATABASE_NAME
    )
    .build()

  fun getPlayers(): Flow<List<ChessPlayer>> = database.chessPlayerDao().getPlayers()

  suspend fun getPlayerByUsername(username: String): ChessPlayerResult {
    var player: ChessPlayerResult
    // Does the database have this player?
    var dbResult = database.chessPlayerDao().getPlayerByUsername(username)
    var apiResult = api.getPlayerByName(username).body()
    if (apiResult == null) {
      throw Exception("No user with this name: [${username}]")
    }
    if (dbResult == null) { // If not, get player and add it to database
      // Add it to the database
database.chessPlayerDao().addPlayer(chessPlayer = ChessPlayer(username = username, id = UUID.randomUUID()))
    }
    return apiResult
  }

  suspend fun getPlayerGames(username: String): GamesResult {
    return checkNotNull(api.getPlayerGames(username).body()) {
      "Can't find games of player [${username}]"
    }
  }

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
