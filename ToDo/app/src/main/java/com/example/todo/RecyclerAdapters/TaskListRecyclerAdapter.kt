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

    class ViewHolder(context: Context,itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        private var context: Context = context

        private var taskLayout: ConstraintLayout
        private var taskDescription: TextView
        private var taskDelete: TextView

        private var fullTaskVisible: Int = View.GONE

        init {
            taskLayout = itemView.findViewById(R.id.clTaskLayout)
            taskDescription = itemView.findViewById(R.id.tvTaskDescription)
            taskDelete = itemView.findViewById(R.id.tvTaskDelete)

            taskLayout.setOnClickListener(this)
            taskDescription.setOnClickListener(this)
            taskDelete.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            when(view?.id){
                R.id.clTaskLayout -> {
                    if(fullTaskVisible == View.VISIBLE){
                        taskLayout.layoutParams.height = Helper.convertDPToPixel(context,64f)
                        taskLayout.setBackgroundResource(0)
                        fullTaskVisible = View.GONE
                    }else{
                        taskLayout.layoutParams.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
                        taskLayout.setBackgroundResource(R.drawable.highlighted_background)
                        fullTaskVisible = View.VISIBLE
                    }
                    taskDescription.visibility = fullTaskVisible
                    taskDelete.visibility = fullTaskVisible
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder: started")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item_layout, parent, false)
        return ViewHolder(context,view)
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