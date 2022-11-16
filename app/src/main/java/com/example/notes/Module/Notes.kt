package com.example.notes.Module


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate=true)
    val id:Int?=null,
    val title:String,
    val subtitle:String,
    val note:String,
    val date:String,
    val periority:String
)


