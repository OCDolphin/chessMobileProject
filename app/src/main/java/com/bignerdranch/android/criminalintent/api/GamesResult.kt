package com.bignerdranch.android.criminalintent.api

import androidx.recyclerview.widget.RecyclerView

data class GamesResult(
  val games: List<GameResult>
): RecyclerView.ViewHolder
