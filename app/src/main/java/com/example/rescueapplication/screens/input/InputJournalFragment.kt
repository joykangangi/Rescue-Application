 package com.example.rescueapplication.screens.input

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rescueapplication.R
import com.example.rescueapplication.databinding.FragmentInputJournalBinding
import com.example.rescueapplication.db.JournalDatabase
import com.example.rescueapplication.db.dao.JournalDao
import java.text.SimpleDateFormat
import java.util.*


 class InputJournalFragment : Fragment() {
   private var _binding: FragmentInputJournalBinding?  = null //current instance of views
    private val binding get() = _binding!! //return the current instance
    //private val sharedViewModel: InputViewModel by activityViewModels()
     private lateinit var sharedViewModel: InputViewModel

    private lateinit var dao: JournalDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputJournalBinding.inflate(inflater, container, false)
        dao = JournalDatabase.invoke(requireContext()).journalDao()
       sharedViewModel = ViewModelProvider(requireActivity(), InputViewModelFactory(dao)).get(InputViewModel::class.java)

        binding.saveBtn.setOnClickListener {
            if (isInputValid()) {
                val journalName = binding.journalEti.text.toString()
                val journalDescription = binding.writeEti.text.toString()
                Log.i(
                    "InputJournalFragment",
                    "the journal data is $journalName and $journalDescription"
                )

                sharedViewModel.saveJournal(
                    journalName,
                    journalDescription,
                    SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
                )
                sharedViewModel.passTheMessage(journalName, journalDescription)

                val action =
                    InputJournalFragmentDirections.actionInputJournalFragmentToListJournalFragment()
                findNavController().navigate(action)

            }
        }

        return binding.root
    }
    private fun isInputValid(): Boolean {
      if (binding.journalEti.text.isNullOrBlank()) {
          binding.journalEti.error = getString(R.string.pls_title)
          return false
      }
        if (binding.writeEti.text.isNullOrBlank()) {
            binding.writeEti.error = getString(R.string.pls_write)
            return false
        }
        return true
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


