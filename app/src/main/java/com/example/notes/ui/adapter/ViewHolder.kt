package com.example.notes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.Module.Notes
import com.example.notes.R
import com.example.notes.databinding.ItemNotesBinding


class ViewHolder(val requiredContext: Context, val NotesList:List<Notes>): RecyclerView.Adapter<ViewHolder.ViewHolder>(){

    class ViewHolder(val binding:ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notesList=NotesList[position]

        holder.binding.NoteTitele.text=notesList.title
        holder.binding.notes.text=notesList.subtitle
        holder.binding.date.text=notesList.date

        when(notesList.periority){

            "1"  ->{holder.binding.perirotyDot.setBackgroundResource(R.drawable.round_dot)}
            "2"   ->{holder.binding.perirotyDot.setBackgroundResource(R.drawable.purple_dot)}
            "3"   ->{holder.binding.perirotyDot.setBackgroundResource(R.drawable.green_dot)}
        }
 }

    override fun getItemCount(): Int {
       return NotesList.size
    }
}