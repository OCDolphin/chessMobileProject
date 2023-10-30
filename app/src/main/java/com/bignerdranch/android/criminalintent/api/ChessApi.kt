package com.bignerdranch.android.criminalintent.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChessApi {
  @GET("/titled/{rankAbbrev}")
  suspend fun getTitledPlayers(@Path(value="rankAbbrev") rankAbbrev: String): Response<ChessPlayersResult>

  @GET("/player/{username}/stats")
  suspend fun getPlayerByName(@Path(value="username") username: String): Response<ChessPlayerResult>
}
