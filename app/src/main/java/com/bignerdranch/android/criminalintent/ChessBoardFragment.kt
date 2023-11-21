package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bignerdranch.android.criminalintent.databinding.FragmentChessBoardBinding
import com.bignerdranch.android.criminalintent.databinding.FragmentPlayerListBinding

class ChessBoardFragment: Fragment() {
  private var _binding: FragmentChessBoardBinding? = null
  private val binding
    get() = checkNotNull(_binding) {
      "Cannot access binding because it is null. Is the view visible?"
    }

  private val chessBoardViewModel: ChessBoardViewModel by viewModels() {
    ChessBoardViewModelFactory(args.piecePositions)
  }
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    _binding  = FragmentChessBoardBinding.inflate(inflater, container, false)
    binding.boardRecyclerView.layoutManager = GridLayoutManager(context, 8)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

  }
}
