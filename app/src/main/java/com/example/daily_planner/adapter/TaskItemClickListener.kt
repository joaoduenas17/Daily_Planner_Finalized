package com.example.daily_planner.adapter

import android.app.LauncherActivity.ListItem
import com.example.daily_planner.ToDoList

interface TaskItemClickListener {
    fun editTaskItem(listItem: ToDoList)
    fun completeTaskItem(listItem: ToDoList)
}