package com.example.rescueapplication.screens.sessions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rescueapplication.databinding.FragmentSessionListBinding

class SessionListFragment : Fragment() {
    private var _binding: FragmentSessionListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionListBinding.inflate(inflater, container, false)

        binding.apply {
            patienceBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToPatienceFragment()
                findNavController().navigate(action)
            }
            stressBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToStressFragment()
                findNavController().navigate(action)
            }
            peaceBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToPeaceFragment()
                findNavController().navigate(action)
            }
            fearBtn.setOnClickListener {
                val action = SessionListFragmentDirections.actionSessionListFragmentToFearFragment()
                findNavController().navigate(action)
            }
            depBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToDepressionFragment()
                findNavController().navigate(action)
            }
            hopeBtn.setOnClickListener {
                val action = SessionListFragmentDirections.actionSessionListFragmentToHopeFragment()
                findNavController().navigate(action)
            }
            angBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToAngerFragment()
                findNavController().navigate(action)
            }
            healBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToHealingFragment()
                findNavController().navigate(action)
            }
            anxBtn.setOnClickListener {
                val action =
                    SessionListFragmentDirections.actionSessionListFragmentToAnxietyFragment()
                findNavController().navigate(action)
            }
            loveBtn.setOnClickListener {
                val action = SessionListFragmentDirections.actionSessionListFragmentToLoveFragment()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }
}