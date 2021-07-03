package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rescueapplication.databinding.FragmentLoveBinding
import com.example.rescueapplication.screens.sessions.love

class LoveFragment : Fragment() {
private var _binding: FragmentLoveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoveBinding.inflate(inflater, container, false)
        binding.lvTxt.text = love
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}