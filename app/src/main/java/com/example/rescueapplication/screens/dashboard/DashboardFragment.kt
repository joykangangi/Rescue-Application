package com.example.rescueapplication.screens.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rescueapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment & bind to binding
    _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.writeBtn.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToListJournalFragment()
            findNavController().navigate(action)
        }
        binding.rescueBtn.setOnClickListener {
           val action = DashboardFragmentDirections.actionDashboardFragmentToSessionListFragment()
           findNavController().navigate(action)
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}