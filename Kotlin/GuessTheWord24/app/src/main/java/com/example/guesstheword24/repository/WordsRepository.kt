package com.example.guesstheword24.repository

class WordsRepository {

    private var _wordList : MutableList<String> = mutableListOf<String>(
        "queen",
        "hospital",
        "basketball",
        "cat",
        "change",
        "snail",
        "soup",
        "calendar",
        "sad",
        "desk",
        "guitar",
        "home",
        "railway",
        "zebra",
        "jelly",
        "car",
        "crow",
        "trade",
        "bag",
        "roll",
        "bubble"
    )
    
    val wordList get() = _wordList

    fun resetList() : MutableList<String> {
        _wordList.shuffle()
        return wordList
    }
}