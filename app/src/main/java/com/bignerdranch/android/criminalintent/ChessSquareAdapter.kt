package com.bignerdranch.android.criminalintent

import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.GridItemSquareBinding
import com.bignerdranch.android.criminalintent.databinding.ListItemPlayerBinding

private const val LIGHT = 0x0;
private const val DARK = 0x0;
class ChessSquareHolder(
  private val binding: GridItemSquareBinding
): RecyclerView.ViewHolder(binding.root) {
 fun bind(row: Int, col: Int, piece: Piece?, onSquareClicked: (row: Int, col: Int) -> Unit) {
   if (row % 2 == col % 2)
     binding.bgSquare.setBackgroundColor(LIGHT)
   else
     binding.bgSquare.setBackgroundColor(DARK)

   when(piece) {
     Piece.PAWN -> {
       binding.pieceImage.setImageResource(R.drawable.baseline_mic_24)
     }
     else -> {
       binding.pieceImage.visibility = View.INVISIBLE
     }
   }
 }
}

class ChessSquareAdapter(
  private val board: List<Piece?>,
  private val onSquareClicked: (row: Int, col: Int) -> Unit
): RecyclerView.Adapter<ChessSquareHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChessSquareHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = GridItemSquareBinding.inflate(inflater, parent, false)
    return ChessSquareHolder(binding)
  }
  override fun getItemCount() = 64

  override fun onBindViewHolder(holder: ChessSquareHolder, position: Int) {
    val piece = board[position]
    val row = position.floorDiv(8)
    val col = position.mod(8)
    holder.bind(row, col, piece, onSquareClicked)
  }
}
