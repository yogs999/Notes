package com.example.notes.ui.Fragment

import android.os.Bundle
import android.view.*
//always import this file for searchView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.Module.Notes
import com.example.notes.NotesViewModel.ViewModelNotes
import com.example.notes.R
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.ui.adapter.ViewHolder


class home_Frag : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val ViewModal: ViewModelNotes by viewModels()
    var oldNote = arrayListOf<Notes>()
    lateinit var demoadapter: ViewHolder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        setHasOptionsMenu(true)

        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)

        //find all notes
        ViewModal.getAllNote().observe(viewLifecycleOwner, { NotesList ->
            oldNote = NotesList as ArrayList<Notes>
            demoadapter = ViewHolder(requireContext(), NotesList)
            binding.recyclerView.adapter = demoadapter

        })

        //go to nextActivity
        binding.btnNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home_Frag_to_created_Frag)
        }

        //find all notes filter
        binding.allNOtes.setOnClickListener {
            ViewModal.getAllNote().observe(viewLifecycleOwner, { NotesList ->
                oldNote = NotesList as ArrayList<Notes>
                demoadapter = ViewHolder(requireContext(), NotesList)
                binding.recyclerView.adapter = demoadapter
            })

        }
        //find large notes filter
        binding.largeNOtes.setOnClickListener {
            ViewModal.getLargenotes().observe(viewLifecycleOwner, { NotesList ->
                oldNote = NotesList as ArrayList<Notes>
                demoadapter = ViewHolder(requireContext(), NotesList)
                binding.recyclerView.adapter = demoadapter
            })

        }
        //find mediumNOtes filter
        binding.mediumNOtes.setOnClickListener {
            ViewModal.getmeduimenotes().observe(viewLifecycleOwner, { NotesList ->
                oldNote = NotesList as ArrayList<Notes>
                demoadapter = ViewHolder(requireContext(), NotesList)
                binding.recyclerView.adapter = demoadapter
            })

        }
        //find lowNOtes
        binding.lowNOtes.setOnClickListener {
            ViewModal.getlownotes().observe(viewLifecycleOwner, { NotesList ->
                oldNote = NotesList as ArrayList<Notes>
                demoadapter = ViewHolder(requireContext(), NotesList)
                binding.recyclerView.adapter = demoadapter
            })

        }

        return binding.root
    }

    //for searchBar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_dialog, menu)

        var itme = menu.findItem(R.id.searchBar)

        val searchView = itme.actionView as SearchView
        searchView.queryHint = "search Notes"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterItem(newText)
                return true
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun filterItem(newText: String?) {
        val newFiltreItme = arrayListOf<Notes>()

        for (i in oldNote) {
            if (i.title.contains(newText!!) || i.subtitle.contains(newText))
                newFiltreItme.add(i)
        }
        demoadapter.filtering(newFiltreItme)
    }
}

