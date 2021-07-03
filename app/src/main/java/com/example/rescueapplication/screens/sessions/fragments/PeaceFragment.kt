package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rescueapplication.databinding.FragmentPatienceBinding
import com.example.rescueapplication.databinding.FragmentPeaceBinding
import com.example.rescueapplication.screens.sessions.peace

class PeaceFragment : Fragment() {

    private var _binding: FragmentPeaceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentPeaceBinding.inflate(inflater, container, false)
        binding.peaceTxt.text = peace
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}