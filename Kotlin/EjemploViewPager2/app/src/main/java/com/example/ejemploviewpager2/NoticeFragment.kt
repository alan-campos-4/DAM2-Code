package com.example.ejemploviewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ejemploviewpager2.databinding.FragmentNoticeBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator

class NoticeFragment : Fragment() {
    private var _binding : FragmentNoticeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoticeBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_notice, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpNotice.adapter = NoticeAdapter(this)
        TabLayoutMediator(binding.TabNotice,binding.vpNotice) {
            tab, position ->
                when(position) {
                    0 -> {
                        tab.text = "Inicio"
                        tab.setIcon(R.drawable.ic_home)
                        val badge : BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor =
                            ContextCompat.getColor(requireContext().applicationContext, R.color.red)
                        badge.number=117
                        badge.maxCharacterCount = 3
                        badge.badgeGravity = BadgeDrawable.TOP_START
                    }
                    1 -> {
                        tab.text = "Menú"
                        tab.setIcon(R.drawable.ic_menu)
                    }
                }
        }.attach()
    }
}

class NoticeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment =
            if (position==0)
                Tab1NoticeFragment()
            else
                Tab2NoticeFragment()
        return fragment
    }
}