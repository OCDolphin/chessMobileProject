package com.bignerdranch.android.criminalintent

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.api.GameResult
import com.bignerdranch.android.criminalintent.api.GamesResult
import com.bignerdranch.android.criminalintent.databinding.GridItemGameBinding
import com.bignerdranch.android.criminalintent.databinding.GridItemSquareBinding
import com.bignerdranch.android.criminalintent.PlayerDetailFragment
import java.text.SimpleDateFormat

class ChessGameHolder(
  private val binding: GridItemGameBinding,
  private val parentContext: Context
): RecyclerView.ViewHolder(binding.root) {
  fun bind(game: GameResult, onGameClicked: (GameResult) -> Unit) {
    binding.gameThumbnailPlayers.setText("[${game.white.username}] vs. [${game.black.username}]")
    if(game.startTime != null){
      val dateFormat = SimpleDateFormat("MM/DD/YY")
      val dateString = dateFormat.format(game.startTime)
      binding.gameThumbnailSiteDate.setText(dateString)
    }
    binding.gameThumbnail.setOnClickListener(object: View.OnClickListener {
      override fun onClick (daView: View) {
        Log.d("CHESSGAME_ADAPTER", "Bruh is the gameClicked NOT GETTING CLICKED??????")
        val url = game.url.toString()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        val chooserIntent = Intent.createChooser(
          intent,
          "Open Chess Game in: "
        )
        parentContext.startActivity(chooserIntent)
      }
    })
  }
}

class ChessGameAdapter(
 private val game: List<GameResult>,
 private val onGameClicked: (GameResult) -> Unit

): RecyclerView.Adapter<ChessGameHolder>() {
  private lateinit var parentView: ViewGroup
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChessGameHolder {
    val inflater = LayoutInflater.from(parent.context)
    parentView = parent
    val binding = GridItemGameBinding.inflate(inflater, parent, false)
    return ChessGameHolder(binding, parent.context)
  }

  override fun getItemCount(): Int {
    return game.size
  }

  override fun onBindViewHolder(holder: ChessGameHolder, position: Int) {
    holder.bind(game[position], onGameClicked)
  }
}
