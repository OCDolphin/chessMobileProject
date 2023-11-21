package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import kotlinx.coroutines.flow.Flow

@Dao
interface ChessPlayerDao {
    @Query("SELECT * FROM ChessPlayer")
    fun getPlayers(): Flow<List<ChessPlayer>>

    @Query("SELECT * FROM ChessPlayer WHERE username=(:username)")
    suspend fun getPlayerByUsername(username: String): ChessPlayer?

    @Update
    suspend fun updatePlayer(chessPlayer: ChessPlayer)

    @Insert
    suspend fun addPlayer(chessPlayer: ChessPlayer)
}
