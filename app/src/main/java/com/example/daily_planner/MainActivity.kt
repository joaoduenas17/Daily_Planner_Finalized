package com.example.daily_planner

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.next)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, PageDoList:: class.java)
            startActivity(intent)
            }
        val imageView: ImageView = findViewById(R.id.imagen_logo)
        imageView.setImageResource(R.drawable.logo_fondo)
    }

}
