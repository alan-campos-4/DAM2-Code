package com.example.guesstheword24.dependencies

import com.example.guesstheword24.repository.WordsRepository
import com.example.guesstheword24.screens.game.GameViewModel

class GameVMFactory(private val wordsRepository: WordsRepository) : Factory<GameViewModel> {

    var gameVM : GameViewModel? = null
    override fun create() : GameViewModel {
        if (gameVM == null)
            gameVM = GameViewModel(wordsRepository)
        return gameVM!!
    }
}