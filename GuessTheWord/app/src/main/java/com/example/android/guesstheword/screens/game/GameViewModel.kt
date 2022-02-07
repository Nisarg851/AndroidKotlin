package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    init{
        Log.i("ViewModel", "Game ViewModel Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "onCleared: Game ViewModel destroyed!")
    }
}