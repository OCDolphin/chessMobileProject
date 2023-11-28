package com.bignerdranch.android.criminalintent.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChessApi {
  @GET("titled/{rankAbbrev}")
  suspend fun getTitledPlayers(@Path(value="rankAbbrev") rankAbbrev: String): Response<ChessPlayersResult>

  @GET("player/{username}/stats")
  suspend fun getPlayerByName(@Path(value="username") username: String): Response<ChessPlayerResult>

  @GET("player/{username}/games")
  suspend fun getPlayerCurrentGames(@Path(value="username") username: String): Response<GamesResult>

  @GET("player/{username}/games/{year}/{month}")
  suspend fun getPlayerMonthlyArchive(@Path(value="username") username: String,
                                      @Path(value="year") year: String,
                                      @Path(value="month") month: String): Response<GamesResult>
}
