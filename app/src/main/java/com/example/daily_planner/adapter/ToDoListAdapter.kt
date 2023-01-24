package com.example.daily_planner.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daily_planner.ToDoList
import android.view.LayoutInflater
import com.example.daily_planner.R
import com.example.daily_planner.databinding.TaskItemCellBinding

class ToDoListAdapter(private val listItem: List<ToDoList>,private val clickListener: TaskItemClickListener) :  RecyclerView.Adapter<ToDoListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TaskItemCellBinding.inflate(layoutInflater,parent,false)
        return ToDoListViewHolder(parent.context,binding, clickListener)
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        holder.render(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}
