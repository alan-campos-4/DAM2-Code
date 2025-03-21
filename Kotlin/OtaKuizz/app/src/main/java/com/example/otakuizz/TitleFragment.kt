package com.example.otakuizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otakuizz.databinding.ActivityMainBinding
import com.example.otakuizz.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private var _binding : FragmentTitleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //_binding = FragmentTitleBinding.inflate(layoutInflater, container, false)
        _binding = FragmentTitleBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}