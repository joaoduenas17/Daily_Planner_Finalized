package com.example.daily_planner

import android.os.Build
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.daily_planner.databinding.FragmentNewSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
@RequiresApi(Build.VERSION_CODES.O)



class NewFragmentSheet(var listItem: ToDoList?) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNewSheetBinding
    private lateinit var toDoListModel: ToDoListModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (listItem != null){
            binding.titulo.text = "Editar Tarea"
            val editable = Editable.Factory.getInstance()
            binding.txtTexto.text = editable.newEditable(listItem!!.texto)
            binding.desc.text = editable.newEditable(listItem!!.desc)
        }
        else{
            binding.titulo.text = "Nueva Tarea"
        }

        toDoListModel = ViewModelProvider(activity).get(ToDoListModel::class.java)
        binding.botonGuardar.setOnClickListener{
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewSheetBinding.inflate(inflater,container, false)
        return binding.root
    }

    private fun saveAction() {
        val texto = binding.txtTexto.text.toString()
        val desc = binding.desc.text.toString()
        if (listItem == null)
        {
            val newTask = ToDoList(texto,desc,null)

            toDoListModel.addListItem(newTask)
        }
        else{
            toDoListModel.updateListItem(listItem!!.id, texto, desc)
        }
    }

}