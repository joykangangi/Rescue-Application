package com.example.rescueapplication.screens.sessions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rescueapplication.databinding.FragmentQuotesBinding
import com.example.rescueapplication.screens.sessions.quotes

class QuotesFragment : Fragment() {
    private var _binding: FragmentQuotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuotesBinding.inflate(inflater, container, false)
        binding.quotesTxt.text = quotes
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
