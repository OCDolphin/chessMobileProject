package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.api.GameResult
import com.bignerdranch.android.criminalintent.api.GamesResult
import com.bignerdranch.android.criminalintent.databinding.GridItemGameBinding
import com.bignerdranch.android.criminalintent.databinding.GridItemSquareBinding
import java.text.SimpleDateFormat

class ChessGameHolder(
  private val binding: GridItemGameBinding
): RecyclerView.ViewHolder(binding.root) {
  fun bind(game: GameResult, onGameClicked: (GameResult) -> Unit) {
    binding.gameThumbnailPlayers.setText("[${game.white.username}] vs. [${game.black.username}]")
    if(game.startTime != null){
      val dateFormat = SimpleDateFormat("MM/DD/YY")
      val dateString = dateFormat.format(game.startTime)
      binding.gameThumbnailSiteDate.setText(dateString)
    }

  }
}

class ChessGameAdapter(
 private val game: List<GameResult>,
 private val onGameClicked: (GameResult) -> Unit
): RecyclerView.Adapter<ChessGameHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChessGameHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = GridItemGameBinding.inflate(inflater, parent, false)
    return ChessGameHolder(binding)
  }

  override fun getItemCount(): Int {
    return game.size
  }

  override fun onBindViewHolder(holder: ChessGameHolder, position: Int) {
    holder.bind(game[position], onGameClicked)
  }
}
