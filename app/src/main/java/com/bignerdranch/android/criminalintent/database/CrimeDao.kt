package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bignerdranch.android.criminalintent.ChessPlayer
import kotlinx.coroutines.flow.Flow

@Dao
interface CrimeDao {
    @Query("SELECT * FROM ChessPlayer")
    fun getCrimes(): Flow<List<ChessPlayer>>

    @Query("SELECT * FROM ChessPlayer WHERE user=(:user)")
    suspend fun getCrime(user: String): ChessPlayer

    @Update
    suspend fun updateCrime(chessPlayer: ChessPlayer)

    @Insert
    suspend fun addCrime(chessPlayer: ChessPlayer)
}