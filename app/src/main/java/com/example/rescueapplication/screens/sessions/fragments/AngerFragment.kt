package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rescueapplication.databinding.FragmentAngerBinding
import com.example.rescueapplication.screens.sessions.anger

class AngerFragment : Fragment() {

    private var _binding: FragmentAngerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAngerBinding.inflate(inflater, container, false)
        binding.angTxt.text = anger
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    _binding = null
    }
}
