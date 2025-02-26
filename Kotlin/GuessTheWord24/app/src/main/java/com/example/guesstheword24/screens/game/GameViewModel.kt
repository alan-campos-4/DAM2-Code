package com.example.guesstheword24.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.guesstheword24.repository.WordsRepository

class GameViewModel(private val wordsRepository: WordsRepository) : ViewModel() {
    private var _score : Int = 0
    private var _word : String = ""
    private var _wordList : MutableList<String>

    val score get() = _score
    val word get() = _word
    val wordList get() = _wordList

    init {
        Log.i("GameViewModel", "GameViewModel creado!")
        _wordList = wordsRepository.resetList()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destruido!")
    }

    fun onSkip() {
        _score--
        nextWord()
    }

    fun onCorrect() {
        _score++
        nextWord()
    }

    fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word = wordList.removeAt(0)
        } else {
            _word = "No more words."
        }
    }

}