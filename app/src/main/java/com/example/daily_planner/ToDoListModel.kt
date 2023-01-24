package com.example.daily_planner

import android.app.LauncherActivity.ListItem
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.util.UUID
@RequiresApi(Build.VERSION_CODES.O)

class ToDoListModel: ViewModel() {
    var listItem = MutableLiveData<MutableList<ToDoList>>()

    init {
        listItem.value = mutableListOf()
    }

    //Funcion para añadir las tareas
    fun addListItem(newList: ToDoList) {
        val list = listItem.value
        list!!.add(newList)
        listItem.postValue(list)
    }

    // Funcion para poder actualizar las tareas
    fun updateListItem(id: UUID, texto: String, desc: String) {
        val list = listItem.value
        val item = list!!.find { it.id == id }!!
        item.texto = texto
        item.desc = desc
        listItem.postValue(list)
    }
    fun setCompleted(newList: ToDoList) {
        val list = listItem.value
        val item = list!!.find { it.id == newList.id }!!
        if (item.completedDate == null)
            item.completedDate = LocalDate.now()
        listItem.postValue(list)
    }

}