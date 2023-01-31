package com.example.daily_planner

import android.content.Context
import android.widget.CheckBox
import android.widget.EditText
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

data class ToDoList(
    var texto:String,
    var desc:String,
    var check: Boolean,
    var id: UUID = UUID.randomUUID()
)
{
    fun isCompleted()= check!=false
    fun imageResource(): Int= if (isCompleted())R.drawable.check_imagen else R.drawable.uncheck_imagen
    fun imageColor(context: Context): Int= if (isCompleted()) blue(context) else black(context)
    private fun blue(context: Context)= ContextCompat.getColor(context,
        com.google.android.material.R.color.material_blue_grey_800)
    private fun black(context: Context)= ContextCompat.getColor(context,R.color.black)
}