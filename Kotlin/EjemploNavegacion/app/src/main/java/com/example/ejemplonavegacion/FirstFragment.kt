package com.example.ejemplonavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        val btn1 = root.findViewById<Button>(R.id.btnToFragment2)
        btn1.setOnClickListener{
            //findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                name="Felix"
            ))
        }
        val btn2 = root.findViewById<Button>(R.id.btnToFragment3)
        btn2.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        return root
    }
}