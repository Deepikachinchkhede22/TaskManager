package com.example.demo_taskmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class TaskAdapter(
    private val task : ArrayList<Task>
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    interface OnTaskClickListener {
        fun onTaskClick(position: Int, task: Task, view: View)
}
    var onTaskClickListener: OnTaskClickListener? = null

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtId: TextView
        val txtTitle: TextView
        val txtBody: TextView
        val txtDueDate: TextView
        val txtStatus: TextView

        init {
            txtId = view.findViewById(R.id.txtId)
            txtTitle = view.findViewById(R.id.txtTitle)
            txtBody = view.findViewById(R.id.txtBody)
            txtDueDate = view.findViewById(R.id.txtDueDate)
            txtStatus = view.findViewById(R.id.txtStatus)

            itemView.setOnClickListener {
                if (onTaskClickListener != null) {
                    onTaskClickListener!!.onTaskClick(
                        adapterPosition,
                        task[adapterPosition],
                        it
                    )
                }
            }

        }
    }

    override fun getItemCount() = task.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.task_view, null)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.txtId.text = task[position].id.toString()
        holder.txtTitle.text = task[position].title
        holder.txtBody.text = task[position].body
        holder.txtDueDate.text = task[position].dueDate
        holder.txtStatus.text = task[position].status
    }
}