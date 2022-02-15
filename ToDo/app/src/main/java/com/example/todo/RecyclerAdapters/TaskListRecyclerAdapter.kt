package com.example.todo.RecyclerAdapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R

class TaskListRecyclerAdapter(taskList: List<String>): RecyclerView.Adapter<TaskListRecyclerAdapter.ViewHolder>() {

    private var taskList: List<String> = taskList

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder: started")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("RecyclerView", "onBindViewHolder: started")
        val task: String = taskList.get(position)
        holder.itemView.findViewById<TextView>(R.id.tvTaskTitle).text = task
    }

    override fun getItemCount(): Int {
        Log.i("RecyclerView", "getItemCount: ${taskList.size}")
        return taskList.size
    }
}