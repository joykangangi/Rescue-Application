package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rescueapplication.databinding.FragmentHealingBinding
import com.example.rescueapplication.screens.sessions.healing

class HealingFragment : Fragment() {
    private var _binding: FragmentHealingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentHealingBinding.inflate(inflater, container, false)
        binding.healingTxt.text = healing
       return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}