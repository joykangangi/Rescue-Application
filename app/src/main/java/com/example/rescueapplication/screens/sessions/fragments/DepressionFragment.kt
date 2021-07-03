package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rescueapplication.databinding.FragmentDepressionBinding
import com.example.rescueapplication.screens.sessions.depression

class DepressionFragment : Fragment() {
   private var _binding: FragmentDepressionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDepressionBinding.inflate(inflater, container, false)
        binding.depressiTxt.text = depression
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

