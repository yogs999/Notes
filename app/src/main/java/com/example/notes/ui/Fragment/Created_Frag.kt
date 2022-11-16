package com.example.notes.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notes.Module.Notes
import com.example.notes.NotesViewModel.ViewModelNotes
import com.example.notes.R
import com.example.notes.databinding.FragmentCreatedBinding
import java.text.SimpleDateFormat
import java.util.*


class Created_Frag : Fragment() {

    lateinit var Binding:FragmentCreatedBinding
    var perority:String="1"
    val ViewModel : ViewModelNotes by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

            Binding=FragmentCreatedBinding.inflate(layoutInflater,container,false)

            Binding.periority1.setImageResource(R.drawable.ic_baseline_check_24)

            Binding.periority1.setOnClickListener {
                perority="1"
                Binding.periority1.setImageResource(R.drawable.ic_baseline_check_24)
                Binding.periority2.setImageResource(0)
                Binding.periority3.setImageResource(0)

            }

            Binding.periority2.setOnClickListener {
                perority="2"
                Binding.periority2.setImageResource(R.drawable.ic_baseline_check_24)
                Binding.periority1.setImageResource(0)
                Binding.periority3.setImageResource(0)
            }
            Binding.periority3.setOnClickListener {
                perority="3"
                Binding.periority3.setImageResource(R.drawable.ic_baseline_check_24)
                Binding.periority1.setImageResource(0)
                Binding.periority2.setImageResource(0)

            }

            Binding.createdNotes.setOnClickListener{
                CreatedNotes(it)
            }

            return Binding.root
        }


private fun CreatedNotes(it: View?) {

    val title=Binding.edTitle.text.toString()
    val subtitle=Binding.edsubtitle.text.toString()
    val note=Binding.ednote.text.toString()

    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())

    val data= Notes(null,
        title =title,
        subtitle=subtitle,
        note =note,
        date = currentDate.toString(),
        perority

    )
    ViewModel.insertNote(data)

    Toast.makeText(context, "note created successful..", Toast.LENGTH_SHORT).show()

    Navigation.findNavController(it!!).navigate(R.id.action_created_Frag_to_home_Frag)


}

}
