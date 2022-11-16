package com.example.notes.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.notes.NotesViewModel.ViewModelNotes
import com.example.notes.R
import com.example.notes.databinding.FragmentHomeBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.ui.adapter.ViewHolder

class homeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
        val ViewModal:ViewModelNotes by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentHomeBinding.inflate(layoutInflater)


        ViewModal.getAllNote().observe(viewLifecycleOwner,{ NotesList ->

         binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recyclerView.adapter=ViewHolder(requireContext(),NotesList)
        })

        binding.btnNext.setOnClickListener{
           Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createdNoteFragment)
        }

    return binding.root
    }
}