package com.example.notes.ui.Fragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.notes.Module.Notes
import com.example.notes.NotesViewModel.ViewModelNotes
import com.example.notes.R
import com.example.notes.databinding.FragmentEditBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*

class Edit_Frag : Fragment() {

      val oldNotes by navArgs<Edit_FragArgs>()
       var perority:String="1"
     lateinit var binding:FragmentEditBinding

     val viewModel:ViewModelNotes by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentEditBinding.inflate(layoutInflater,container,false)

        setHasOptionsMenu(true)

        binding.EditTitle.setText(oldNotes.data.title)
        binding.Editsubtitle.setText(oldNotes.data.subtitle)
        binding.Editnote.setText(oldNotes.data.note)

        when(oldNotes.data.periority) {

            "1" -> {
                perority = "1"
                binding.periorityx.setImageResource(R.drawable.ic_baseline_check_24)
                binding.periorityY.setImageResource(0)
                binding.periorityZ.setImageResource(0)
            }


            "2" -> {
                perority = "2"
                binding.periorityY.setImageResource(R.drawable.ic_baseline_check_24)
                binding.periorityx.setImageResource(0)
                binding.periorityZ.setImageResource(0)
            }


            "3" -> {
                perority = "3"
                binding.periorityZ.setImageResource(R.drawable.ic_baseline_check_24)
                binding.periorityY.setImageResource(0)
                binding.periorityx.setImageResource(0)
            }
            }

        binding.periorityx.setOnClickListener {
            perority="1"
            binding.periorityx.setImageResource(R.drawable.ic_baseline_check_24)
            binding.periorityY.setImageResource(0)
            binding.periorityZ.setImageResource(0)

        }

        binding.periorityY.setOnClickListener {
            perority="2"
            binding.periorityY.setImageResource(R.drawable.ic_baseline_check_24)
            binding.periorityx.setImageResource(0)
            binding.periorityZ.setImageResource(0)
        }
        binding.periorityZ.setOnClickListener {
            perority="3"
            binding.periorityZ.setImageResource(R.drawable.ic_baseline_check_24)
            binding.periorityY.setImageResource(0)
            binding.periorityx.setImageResource(0)

        }


        binding.done.setOnClickListener {
            updateNote(it)
        }

        return binding.root
}

    private fun updateNote(it: View?) {

        val titlee=binding.EditTitle.text.toString()
        val subTitle=binding.Editsubtitle.text.toString()
        val note=binding.Editnote.text.toString()

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        val data=Notes(oldNotes.data.id,
         title=titlee,
         subtitle=subTitle
         ,note=note,
          date = currentDate.toString()
         , perority
            )
        viewModel.updateAllNotes(data)

        Toast.makeText(context, "note update successful", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_edit_Frag_to_home_Frag)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.menu_delete) {
            val bottomsheet: BottomSheetDialog = BottomSheetDialog(requireContext(),R.style.ButtomstyleSheet)
            bottomsheet.setContentView(R.layout.delete_dialog)


            val btnno=bottomsheet.findViewById<TextView>(R.id.btnNo)
            val btnyes=bottomsheet.findViewById<TextView>(R.id.btnyes)

            btnno?.setOnClickListener {
                bottomsheet.dismiss()
            }
            btnyes?.setOnClickListener {
             viewModel.DeleteAllNotes(oldNotes.data.id!!)
                bottomsheet.dismiss()
                  }

            bottomsheet.show()

        }
        return super.onOptionsItemSelected(item)
    }

}