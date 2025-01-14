package com.example.ejemplonavegacionmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class AboutFragment : Fragment() {

    val args:AboutFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        root.findViewById<TextView>(R.id.tvFragmentA).text =
            getString(R.string.hello_About, args.user)
        return root
    }

}