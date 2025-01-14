package com.example.ejemplonavegacionmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navDeepLink
import com.example.ejemplonavegacionmenu.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val btnHome = root.findViewById<Button>(R.id.btnAbout)
        btnHome.setOnClickListener {
            //Primera forma
            //val request = R.id.action_HomeFragment_to_aboutFragment

            //Segunda forma
            //val request = HomeFragmentDirections.actionHomeFragmentToAboutFragment(user = "Prueba")

            //Tercera forma: DeepLink
            val request = NavDeepLinkRequest.Builder.fromUri("android:app://com.example.ejemplonavegacionmenu.AboutFragment".toUri())
                .build()

            findNavController().navigate(request)
        }
        return root
        */

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHomeToAbout.setOnClickListener {
            val request = HomeFragmentDirections.actionHomeFragmentToAboutFragment(user = "Prueba")
            findNavController().navigate(request)
        }
    }
}