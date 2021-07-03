package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rescueapplication.databinding.FragmentHopeBinding
import com.example.rescueapplication.screens.sessions.hope

class HopeFragment : Fragment() {
    private var _binding: FragmentHopeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentHopeBinding.inflate(inflater, container, false)
        binding.hopeTxt.text = hope
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}