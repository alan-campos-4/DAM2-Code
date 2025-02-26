package com.example.guesstheword24.screens.score

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.guesstheword24.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {

    private lateinit var binding : FragmentScoreBinding
    private val args : ScoreFragmentArgs by navArgs()
    private val scoreVM : ScoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater,container,false)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scoreVM.setFinalScore(args.score)
        binding.scoreText.text = scoreVM.finalScore.toString()
    }


}