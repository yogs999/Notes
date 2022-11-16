package com.example.notes.databaseNotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.Dao.NotesDao
import com.example.notes.Module.Notes



@Database(entities = arrayOf(Notes::class),version=2, exportSchema = false)

   abstract class NotesDatabase :RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {

        var INSTANCES:NotesDatabase?=null

        fun getInstance(context: Context):NotesDatabase{

            val tempInstance= INSTANCES
           if(tempInstance!=null){
               return tempInstance
           }
             synchronized(this){
               var database=Room.databaseBuilder(context,NotesDatabase::class.java,"demodb").allowMainThreadQueries().build()
                    INSTANCES=database
                   return database
             }
        }
    }

}