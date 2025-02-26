package com.example.guesstheword24.dependencies

import android.content.Context
import com.example.guesstheword24.repository.WordsRepository

class AppContainer(context: Context) {

    //Repositorio de palabras.
    private val _wordsRepository : WordsRepository = WordsRepository()
    val wordsRepository get() = _wordsRepository

    //Factory de ViewModel de Game.
    private val _gameVMFactory = GameVMFactory(wordsRepository)
    val gameVMFactory get() = _gameVMFactory

}