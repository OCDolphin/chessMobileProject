package com.bignerdranch.android.criminalintent

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.criminalintent.database.CrimeDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

private const val DATABASE_NAME = "crime-database"

class ChessPlayerRepository private constructor(
    context: Context,
    private val coroutineScope: CoroutineScope = GlobalScope
) {

    private val database: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .build()

    fun getCrimes(): Flow<List<ChessPlayer>> = database.crimeDao().getCrimes()

    suspend fun getCrime(id: String): ChessPlayer = database.crimeDao().getCrime(id)

    fun updateCrime(chessPlayer: ChessPlayer) {
        coroutineScope.launch {
            database.crimeDao().updateCrime(chessPlayer)
        }
    }

    suspend fun addCrime(chessPlayer: ChessPlayer) {
        database.crimeDao().addCrime(chessPlayer)
    }

    companion object {
        private var INSTANCE: ChessPlayerRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ChessPlayerRepository(context)
            }
        }

        fun get(): ChessPlayerRepository {
            return INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}