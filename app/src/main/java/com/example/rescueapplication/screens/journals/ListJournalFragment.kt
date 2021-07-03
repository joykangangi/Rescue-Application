package com.example.rescueapplication.screens.journals

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rescueapplication.databinding.FragmentListJournalBinding
import com.example.rescueapplication.db.JournalDatabase
import com.example.rescueapplication.db.dao.JournalDao

class ListJournalFragment : Fragment() {
    /**
     * associating the viewModel with its UI controller(this fragment)
     */
   private lateinit var viewModel: JournalViewModel
   private var _binding: FragmentListJournalBinding?  = null //current instance of views
   private val binding get() = _binding!! //return the current instance

    private lateinit var dao: JournalDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
       _binding = FragmentListJournalBinding.inflate(inflater, container, false)

        dao = JournalDatabase.invoke(requireContext()).journalDao()

        Log.i("ListJournalFragment", "Called JournalViewModelProviders")

      viewModel = ViewModelProvider(this, JournalViewModelFactory(dao)).get(JournalViewModel::class.java)
        val adapter = JournalListAdapter {
           val action = ListJournalFragmentDirections.actionListJournalFragmentToViewJournalFragment()
            findNavController().navigate(action)
        }

        viewModel.journalList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        binding.journalRv.adapter = adapter

        binding.addFab.setOnClickListener {
            val action = ListJournalFragmentDirections.actionListJournalFragmentToInputJournalFragment()
            findNavController().navigate(action)
        }

return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}