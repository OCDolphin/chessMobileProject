package com.bignerdranch.android.criminalintent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import com.bignerdranch.android.criminalintent.databinding.ListItemPlayerBinding

private const val TAG = "PlayerHolder"

class PlayerHolder(
    private val binding: ListItemPlayerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(chessPlayer: ChessPlayer, onPlayerClicked: (username: String) -> Unit) {
      binding.playerUser.setText(chessPlayer.username)


      binding.root.setOnClickListener {
        onPlayerClicked(chessPlayer.username)
      }
      Log.d(TAG, "bind called")
    }
}

class PlayerListAdapter(
  private val chessPlayers: List<ChessPlayer>,
  private val onPlayerClicked: (playerName: String) -> Unit
) : RecyclerView.Adapter<PlayerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemPlayerBinding.inflate(inflater, parent, false)
        return PlayerHolder(binding)
    }

    override fun getItemCount() = chessPlayers.size

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        val crime = chessPlayers[position]
        holder.bind(crime, onPlayerClicked)
    }
}
