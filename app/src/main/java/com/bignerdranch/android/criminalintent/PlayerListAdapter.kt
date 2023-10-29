package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(chessPlayer: ChessPlayer, onCrimeClicked: (crimeId: String) -> Unit) {
        binding.playerUser.text = chessPlayer.user

        binding.root.setOnClickListener {
            onCrimeClicked(chessPlayer.user)
        }
    }
}

class CrimeListAdapter(
    private val chessPlayers: List<ChessPlayer>,
    private val onCrimeClicked: (crimeId: String) -> Unit
) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun getItemCount() = chessPlayers.size

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = chessPlayers[position]
        holder.bind(crime, onCrimeClicked)
    }
}