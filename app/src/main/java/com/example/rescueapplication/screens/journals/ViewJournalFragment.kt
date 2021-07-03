 package com.example.rescueapplication.screens.journals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rescueapplication.databinding.FragmentViewJournalBinding
import com.example.rescueapplication.db.JournalDatabase
import com.example.rescueapplication.db.dao.JournalDao
import com.example.rescueapplication.screens.input.InputViewModel
import com.example.rescueapplication.screens.input.InputViewModelFactory

 class ViewJournalFragment : Fragment() {

    private var _binding: FragmentViewJournalBinding?  = null //current instance of views
    private val binding get() = _binding!! //return the current instance
    //private val sharedViewModel: InputViewModel by activityViewModels()
    private lateinit var dao: JournalDao
     private lateinit var sharedViewModel: InputViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
      _binding = FragmentViewJournalBinding.inflate(inflater, container, false)
        dao = JournalDatabase.invoke(requireContext()).journalDao()
        sharedViewModel = ViewModelProvider(requireActivity(), InputViewModelFactory(dao)).get(InputViewModel::class.java)
        sharedViewModel.theTitle.observe(viewLifecycleOwner, { theTitle->
            binding.journalTitle.text = theTitle
        })
        sharedViewModel.theDesc.observe(viewLifecycleOwner, { theDesc->
            binding.journalDescription.text = theDesc
        })
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}