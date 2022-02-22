package com.example.todo.RecyclerAdapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.Helper
import com.example.todo.R

class TaskListRecyclerAdapter(context: Context, taskList: List<String>): RecyclerView.Adapter<TaskListRecyclerAdapter.ViewHolder>() {

    private var context: Context = context
    private var taskList: List<String> = taskList

    class ViewHolder(context: Context,itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder: started")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item_layout, parent, false)
        return ViewHolder(context,view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("RecyclerView", "onBindViewHolder: started")
        val task: String = taskList.get(position)
    }

    override fun getItemCount(): Int {
        Log.i("RecyclerView", "getItemCount: ${taskList.size}")
        return taskList.size
    }
}