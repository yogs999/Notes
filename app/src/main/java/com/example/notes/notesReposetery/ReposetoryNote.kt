package com.example.notes.notesReposetery


import androidx.lifecycle.LiveData
import com.example.notes.Dao.NotesDao
import com.example.notes.Module.Notes

open class ReposetoryNote(val dao: NotesDao) {

    fun InsertNotes(notes: Notes) {
        return dao.InsertNotes(notes)
    }

   fun getAll(): LiveData<List<Notes>> {
     return  dao.getAll()
    }

   fun DeleteNotes(id:Int) {
    return dao.DeleteNotes(id)
    }

    fun Update(notes: Notes) {
        return dao.Update(notes)
    }
}