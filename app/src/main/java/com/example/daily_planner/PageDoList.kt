package com.example.daily_planner

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daily_planner.adapter.TaskItemClickListener
import com.example.daily_planner.adapter.ToDoListAdapter
import com.example.daily_planner.databinding.ActivityMainBinding
import com.example.daily_planner.databinding.ActivityToDoListBinding
@RequiresApi(Build.VERSION_CODES.O)


class PageDoList : AppCompatActivity(),TaskItemClickListener {

    private lateinit var binding: ActivityToDoListBinding
    private lateinit var toDoListModel: ToDoListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toDoListModel = ViewModelProvider(this).get(ToDoListModel::class.java)
        binding.taskButton.setOnClickListener{
            NewFragmentSheet(null).show(supportFragmentManager,"newTaskTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val mainActivity = this
        toDoListModel.listItem.observe(this){
            binding.recyclerDoList.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = ToDoListAdapter(it,mainActivity)
            }
        }
    }

    override fun editTaskItem(listItem: ToDoList) {
        NewFragmentSheet(listItem).show(supportFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(listItem: ToDoList) {
        toDoListModel.setCompleted(listItem)
    }
}