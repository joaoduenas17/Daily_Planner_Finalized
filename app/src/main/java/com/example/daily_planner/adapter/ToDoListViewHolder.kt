package com.example.daily_planner.adapter

import android.content.Context
import android.graphics.Paint
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.daily_planner.R
import com.example.daily_planner.ToDoList
import com.example.daily_planner.databinding.TaskItemCellBinding

class ToDoListViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
): ViewHolder(binding.root) {

    fun render(listItem: ToDoList){
        binding.texto.text = listItem.texto

        if (listItem.isCompleted()){
            binding.texto.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
        binding.botonCompletar.setImageResource(listItem.imageResource())
        binding.botonCompletar.setColorFilter(listItem.imageColor(context))

        binding.botonCompletar.setOnClickListener{
            clickListener.completeTaskItem(listItem)
        }
        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(listItem)
        }

    }
}