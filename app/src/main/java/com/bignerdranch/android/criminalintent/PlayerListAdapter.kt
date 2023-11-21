package com.bignerdranch.android.criminalintent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import com.bignerdranch.android.criminalintent.databinding.ListItemPlayerBinding

private const val TAG = "PlayerHolder"

class PlayerHolder(
    private val binding: ListItemPlayerBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(username: String, onPlayerClicked: (username: String) -> Unit) {
      binding.playerUser.setText(username)

      binding.root.setOnClickListener {
        onPlayerClicked(username)
      }
      Log.d(TAG, "bind called")
    }
}

class PlayerListAdapter(
  private val chessPlayers: List<String>,
  private val onPlayerClicked: (username: String) -> Unit
) : RecyclerView.Adapter<PlayerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemPlayerBinding.inflate(inflater, parent, false)
        return PlayerHolder(binding)
    }

    override fun getItemCount() = chessPlayers.size

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        val player = chessPlayers[position]
        holder.bind(player, onPlayerClicked)
    }
}
