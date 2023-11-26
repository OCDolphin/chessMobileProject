package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bignerdranch.android.criminalintent.api.ChessPlayerResult
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import com.bignerdranch.android.criminalintent.databinding.FragmentPlayerDetailBinding
import kotlinx.coroutines.launch
import java.lang.IllegalStateException
import java.text.DateFormat

private const val TAG = "PlayerDetailFragment"
class PlayerDetailFragment : Fragment() {

  private var _binding: FragmentPlayerDetailBinding? = null
  private val binding
    get() = checkNotNull(_binding) {
      "Cannot access binding because it is null. Is the view visible?"
    }

  private val args: PlayerDetailFragmentArgs by navArgs()

  private val playerDetailViewModel: PlayerDetailViewModel by viewModels() {
    ChessPlayerDetailViewModelFactory(args.username)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding =
      FragmentPlayerDetailBinding.inflate(inflater, container, false)
    binding.fragmentContainer.layoutManager = GridLayoutManager(context, 3)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewLifecycleOwner.lifecycleScope.launch {
      viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
        playerDetailViewModel.init() {
          updateUi(playerDetailViewModel.username, checkNotNull(playerDetailViewModel.chessPlayer.value){
            throw IllegalStateException("Player must not be null")
          })
        }
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun updateUi(username: String, chessPlayer: ChessPlayerResult) {

    binding.apply {
      if (chessPlayer.chess_daily != null) {
        if (chessPlayer.chess_daily.last != null) {
          if (chessPlayer.chess_daily.last.date != null) {
            chessDailyLastDateTextview.setText(chessPlayer.chess_daily.last.date.toString())
          }
          if (chessPlayer.chess_daily.last.rating != null) {
            chessDailyLastRatingTextview.setText(chessPlayer.chess_daily.last.rating.toString())
          }
          if (chessPlayer.chess_daily.last.rd != null) {
            chessDailyLastRdTextview.setText(chessPlayer.chess_daily.last.rd.toString())
          }
        }

        if(chessPlayer.chess_daily.best != null) {
          if (chessPlayer.chess_daily.best.date != null) {
            chessDailyBestDateTextview.setText(chessPlayer.chess_daily.best.date.toString())
          }
          if (chessPlayer.chess_daily.best.rating != null) {
            chessDailyBestRatingTextview.setText(chessPlayer.chess_daily.best.rating.toString())
          }
          if (chessPlayer.chess_daily.best.game != null) {
            chessDailyBestUrlTextview.setText(chessPlayer.chess_daily.best.game)
          }
        }
      }
      if (chessPlayer.chess960_daily != null) {
        if (chessPlayer.chess960_daily.last != null) {
          if (chessPlayer.chess960_daily.last.date != null) {
            chessDaily960LastDateTextview.setText(chessPlayer.chess960_daily.last.date.toString())
          }
          if (chessPlayer.chess960_daily.last.rating != null) {
            chessDaily960LastRatingTextview.setText(chessPlayer.chess960_daily.last.rating.toString())
          }
          if (chessPlayer.chess960_daily.last.rd != null) {
            chessDaily960LastRdTextview.setText(chessPlayer.chess960_daily.last.rd.toString())
          }
        }

        if (chessPlayer.chess960_daily.best != null) {
          if (chessPlayer.chess960_daily.best.date != null) {
            chessDaily960BestDateTextview.setText(chessPlayer.chess960_daily.best.date.toString())
          }
          if (chessPlayer.chess960_daily.best.rating != null) {
            chessDaily960BestRatingTextview.setText(chessPlayer.chess960_daily.best.rating.toString())
          }
          if (chessPlayer.chess960_daily.best.game != null) {
            chessDaily960BestUrlTextview.setText(chessPlayer.chess960_daily.best.game)
          }
        }
      }
    }
  }
}
