package com.example.todo.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var taskList: RecyclerView
    private lateinit var taskInputLayout: TextInputLayout
    private lateinit var taskInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Recycler View
        var tasks: List<String> = ArrayList<String>()
        taskList = binding.rvTaskList


        taskInputLayout = binding.taskInputLayout
        taskInput = binding.etTaskInput
    }
}