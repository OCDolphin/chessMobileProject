package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.criminalintent.database.ChessPlayer
import com.bignerdranch.android.criminalintent.databinding.FragmentPlayerDetailBinding
import kotlinx.coroutines.launch

class PlayerDetailFragment : Fragment() {

  private var _binding: FragmentPlayerDetailBinding? = null
  private val binding
    get() = checkNotNull(_binding) {
      "Cannot access binding because it is null. Is the view visible?"
    }

  private val args: PlayerDetailFragmentArgs by navArgs()

  private val playerDetailViewModel: PlayerDetailViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding =
      FragmentPlayerDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewLifecycleOwner.lifecycleScope.launch {
      viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun updateUi(chessPlayer: ChessPlayer) {
    binding.apply {

      //Need to populate fragment_player_view when finished

//            if (crimeTitle.text.toString() != chessPlayer.title) {
//                crimeTitle.setText(chessPlayer.title)
//            }
//            crimeDate.text = chessPlayer.date.toString()
//            crimeDate.setOnClickListener {
//                findNavController().navigate(
//                    CrimeDetailFragmentDirections.selectDate(chessPlayer.date)
//                )
//            }
//            crimeSolved.isChecked = chessPlayer.isSolved
    }
  }
}
