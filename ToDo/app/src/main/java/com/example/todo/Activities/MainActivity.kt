package com.example.todo.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.RecyclerAdapters.TaskListRecyclerAdapter
import com.example.todo.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // binding variable
    private lateinit var binding: ActivityMainBinding

    // Layout ViewGroups and Containers
    private lateinit var rvTaskList: RecyclerView

    // Layout views
    private lateinit var taskInputLayout: TextInputLayout
    private lateinit var taskInput: TextInputEditText

    // Other Variables
    val tasks = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // initiating binding variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initiateRecyclerView()

        taskInputLayout = binding.taskInputLayout
        taskInput = binding.etTaskInput

        taskInputLayout.setEndIconOnClickListener(View.OnClickListener {
            val task: Editable? = taskInput.text
            tasks.add(task.toString())
            // refreshes whole layout "Not Efficient"
            rvTaskList.requestLayout()
        })
    }

    private fun initiateRecyclerView(){
        // Recycler View's sample data
        tasks.add("Task1")
        tasks.add("Task2")
        tasks.add("Task3")

        rvTaskList = binding.rvTaskList
        rvTaskList.adapter = TaskListRecyclerAdapter(tasks)
        Log.i("RecyclerView", "onCreate: Adapter bounded")
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}