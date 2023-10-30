package com.bignerdranch.android.criminalintent.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.chess.com/pub/"

object ApiHelper {
  fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
          .build()
  }
}
