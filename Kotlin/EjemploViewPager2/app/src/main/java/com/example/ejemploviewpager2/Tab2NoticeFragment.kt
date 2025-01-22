package com.example.ejemploviewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejemploviewpager2.databinding.FragmentTab2NoticeBinding

class Tab2NoticeFragment : Fragment() {

    private var _binding : FragmentTab2NoticeBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentTab2NoticeBinding.inflate(inflater,container,false)
        //return inflater.inflate(R.layout.fragment_tab2_notice, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.action_noticeFragment_to_menuFragment)
        }
    }
}