package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.criminalintent.api.ApiHelper
import com.bignerdranch.android.criminalintent.api.ChessApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.app_toolbar))

        val chessApi = ApiHelper.getInstance().create(ChessApi::class.java)
        GlobalScope.launch {
          val result = chessApi.getTitledPlayers("GM")
          if (result != null)
            Log.d("MainActivity", result.body()?.players.toString())
        }
    }
}
