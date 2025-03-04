package com.example.guesstheword24.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guesstheword24.R
import com.example.guesstheword24.databinding.FragmentGameBinding
import com.example.guesstheword24.dependencies.MyApplication
import com.google.android.material.snackbar.Snackbar

class GameFragment : Fragment() {
    private lateinit var gameVM : GameViewModel
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = FragmentGameBinding.inflate(inflater,container,false)

        //Listeners
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame() }

        val appContainer = (requireActivity().application as MyApplication).appContainer
        gameVM = appContainer.gameVMFactory.create()

        //initialization.
        updateScoreText()
        updateWordText()

        return binding.root
    }

    /** Methods for buttons presses **/
    fun onSkip() {
        gameVM.onSkip()
        updateWordText()
        updateScoreText()
    }
    fun onCorrect() {
        gameVM.onCorrect()
        updateWordText()
        updateScoreText()
    }
    fun onEndGame() {
        Snackbar.make(requireView(), getString(R.string.end_of_game), Snackbar.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment(score = gameVM.score)
        findNavController().navigate(action)
    }

    /** Methods for updating the UI **/
    private fun updateWordText() {
        binding.wordText.text = gameVM.word
    }
    private fun updateScoreText() {
        gameVM.score.toString().also { binding.scoreText.text = it }
    }

}