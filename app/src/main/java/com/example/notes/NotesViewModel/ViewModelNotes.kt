package com.example.notes.NotesViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.Module.Notes
import com.example.notes.databaseNotes.NotesDatabase
import com.example.notes.notesReposetery.ReposetoryNote

class ViewModelNotes(application: Application) :AndroidViewModel(application){

    val repository:ReposetoryNote

    init {
        val dao =NotesDatabase.getInstance(application).notesDao()
        repository=ReposetoryNote(dao)
    }

      fun insertNote(notes: Notes) {
        repository.InsertNotes(notes)
    }

    fun getAllNote(): LiveData<List<Notes>> = repository.getAll()

    fun DeleteAllNotes(id:Int){
        repository.DeleteNotes(id)
    }
    fun updateAllNotes(notes: Notes){
        repository.Update(notes)
    }


}