package com.example.cursoaristidevs.androidmaster.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoaristidevs.R

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUi()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
    }

    private fun initUi() {

    }
}
