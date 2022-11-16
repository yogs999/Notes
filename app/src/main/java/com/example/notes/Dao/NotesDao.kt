package com.example.notes.Dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Module.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertNotes(notes: Notes)


    @Query("select * from Notes")
    fun getAll():LiveData<List<Notes>>

    @Query("delete from Notes where id=:id")
    fun DeleteNotes(id:Int)

    @Update
    fun Update(notes: Notes)



}